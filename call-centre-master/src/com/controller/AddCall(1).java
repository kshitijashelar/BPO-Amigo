package com.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algorithm.BayesClassifier;
import com.algorithm.Classifier;
import com.algorithm.Stemming;
import com.algorithm.Stopwords;
import com.constant.Constant;
import com.constant.ConstantMethod;
import com.database.Database;
import com.model.Call;
import com.model.Dataset;
import com.model.Result;
import com.model.SentimentDataset;
import com.service.CallService;
import com.service.DatasetService;
import com.service.ResultService;
import com.service.SentimentDatasetService;
import com.service.UserService;
import com.service.impl.CallServiceImpl;
import com.service.impl.DatasetServiceImpl;
import com.service.impl.ResultServiceImpl;
import com.service.impl.SentimentDatasetServiceImpl;
import com.service.impl.UserServiceImpl;

import net.didion.jwnl.JWNL;

/**
 * Servlet implementation class AddCall
 */
@WebServlet("/AddCall")
public class AddCall extends HttpServlet implements Constant {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	RequestDispatcher rd;
	String url_path;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCall() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		try {
			JWNL.initialize(new FileInputStream(WORDNET_DICTIONARY_PATH + "file_properties.xml"));
		} catch (Exception ex) {
			System.err.println("  Exception initialising Dictionary.  " + ex.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession(true);
		url_path = "./add_call.jsp";
		String callTextData = request.getParameter("call_data_text");
		/**
		 * Apply Naive Bayes Algorithm here
		 */

		final Classifier<String, String> bayes = new BayesClassifier<String, String>();
		DatasetService datasetService = new DatasetServiceImpl();
		List<Dataset> datasets = datasetService.getAllTrainData();
		for (Dataset dataset : datasets) {
			/**
			 * TRAIN NB CLASSIFIER
			 */
			bayes.learn(dataset.getCategoryName(), Arrays.asList(dataset.getProcessedTextData().split("\\s+")));
		}
		
		SentimentDatasetService sentimentDatasetService = new SentimentDatasetServiceImpl();
		List<SentimentDataset> sentimentDatasets = sentimentDatasetService.loadDataset();
		/**
		 * All call review train dataset 
		 */
		final Classifier<String, String> naiveBayes = new BayesClassifier<String, String>();
        for(SentimentDataset sentimentDataset : sentimentDatasets) {
        	/**
        	 * TRAIN MODULE
        	 */
        	naiveBayes.learn(sentimentDataset.getCategoryName(), sentimentDataset.getFeatureSet());
        }
		Call call = new Call();
		int callId = ConstantMethod.getNewID(Database.getConnection(), TABLE_NAME_CALL, CALL_ID);
		call.setCallId(callId);
		call.setCallText(callTextData);
		call.setAddCallDate(ConstantMethod.getCurrentDateAndTime());
		call.setStatus(1);
		int userId = Integer.parseInt(session.getAttribute("user_id_session").toString());
		UserService userService = new UserServiceImpl();
		call.setUser(userService.findByUserId(userId));
		String stopwordRemoveableText = "";
        callTextData = callTextData.toLowerCase();
		for (String word : callTextData.split("\\s+")) {
			if (!Stopwords.isStopword(word)) {
				stopwordRemoveableText += word + " ";
			}
		}
		String processesTextData = Stemming.getBaseForm(stopwordRemoveableText);

		call.setProcessesText(processesTextData);

		CallService callService = new CallServiceImpl();
		if (callService.save(call)) {

			/**
			 * APPPLY CLASSIFIER
			 */
			String predictCategoryName = naiveBayes.classify(Arrays.asList(processesTextData.split("\\s+"))).getCategory();
			float probability = naiveBayes.classify(Arrays.asList(processesTextData.split("\\s+"))).getProbability();

			session.setAttribute("msg", "Call text data added successfully.");
			session.setAttribute("flag", "1");
			session.setAttribute("sentimentCategory", predictCategoryName);
			session.setAttribute("probability", probability);
			session.setAttribute("sentence", callTextData);
			/**
			 * 
			 * ASPECT WISE RESULT
			 */
			Result result = new Result();
			result.setCall(call);
			result.setSentimentCategory(predictCategoryName);
			result.setProbability(probability);

			StringBuilder aspectResult = new StringBuilder();
			for (String lines : callTextData.split("\n")) {
				for(String line  : lines.split(" and | but | also | or |\\.")) {
				String lineStopwordsRemovable = "";
				for (String word : line.split("\\s+")) {
					if (!Stopwords.isStopword(word)) {
						lineStopwordsRemovable += word + " ";
					}
				}

				String predictCategory = bayes.classify(Arrays.asList(lineStopwordsRemovable.split("\\s+")))
						.getCategory();
				float classProbability = bayes.classify(Arrays.asList(lineStopwordsRemovable.split("\\s+")))
						.getProbability();
				/**
				 *
				 * IMPROVE DATASET
				 * 
				 */
                 Dataset dataset = new Dataset();
                 dataset.setCallTextData(line);
                 dataset.setProcessedTextData(lineStopwordsRemovable);
                 dataset.setCategoryName(predictCategory);
                 if(datasetService.save(dataset)) {
                	 System.out.println("Add train dataset....");
                 }
                 
				aspectResult.append("categoryName=").append(predictCategory).append(",").append("probability=")
						.append(classProbability + "").append("\n");
			}
			}

			result.setAspectResult(aspectResult.toString());

			ResultService resultService = new ResultServiceImpl();
			if (resultService.save(result)) {
				session.setAttribute("aspectResult", aspectResult.toString());
			}

		} else {
			session.setAttribute("msg", "Call not stored into database.");
			session.setAttribute("flag", "0");
		}

		rd = request.getRequestDispatcher(url_path);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
