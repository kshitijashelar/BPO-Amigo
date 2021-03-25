package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import com.algorithm.Stemming;
import com.algorithm.Stopwords;
import com.constant.Constant;
import com.model.Dataset;
import com.model.Result;
import com.model.User;
import com.service.CallService;
import com.service.DatasetService;
import com.service.ResultService;
import com.service.impl.CallServiceImpl;
import com.service.impl.DatasetServiceImpl;
import com.service.impl.ResultServiceImpl;

import net.didion.jwnl.JWNL;

public class Test implements Constant {
	public static void main(String[] args) {
      CallService callService = new CallServiceImpl();
//      File file = new File("D:\\Spring\\sts-bundle\\2018\\BE\\call-centre-master\\WebContent\\call_audio_file\\E4.mp3");
//      String voiceToTextResult = callService.voiceToText(file);
//      System.out.println("============================================");
//      System.out.println(voiceToTextResult);
//      System.out.println("============================================");
      /**
       * Calculate aspect wise best product...
       */
      
//      ResultService resultService = new ResultServiceImpl();
//      List<User> users = callService.findDistinctUser();
//      List<String> aspectNames = new ArrayList<>();
//      aspectNames.add("service");
//      aspectNames.add("camera");
//      
//      for(User user : users) {
//    	System.out.println(user.toString());  
//        List<Result> results = resultService.findByAspectResult(user.getUserId(), aspectNames);
//        System.out.println("Number of calls :: "+results.size());
//        System.out.println(results.toString());
//        System.out.println("------------------------- --------------- ----------");
//      }
      /**
       * Update processing data set
       */
      try {
			JWNL.initialize(new FileInputStream(WORDNET_DICTIONARY_PATH + "file_properties.xml"));
		} catch (Exception ex) {
			System.err.println("  Exception initialising Dictionary.  " + ex.getMessage());
		}
      
        DatasetService datasetService = new DatasetServiceImpl();
		List<Dataset> datasets = datasetService.getAllTrainData();
		for (Dataset dataset : datasets) {
		   System.out.println(dataset.getRecordId()+" : "+dataset.getProcessedTextData());
		   String processedDataset = dataset.getProcessedTextData();
		   String stopwordRemoveableText = "";

			for (String word : processedDataset.split("\\s+")) {
				if (!Stopwords.isStopword(word)) {
					stopwordRemoveableText += word + " ";
				}
			}
			String processedTextData = Stemming.getBaseForm(stopwordRemoveableText.toLowerCase());
			System.out.println("Processed :: "+processedTextData);
			dataset.setProcessedTextData(processedTextData);
			if(datasetService.update(dataset)) {
				System.out.println("UPDATE...");
			}
			System.out.println("-------------- ---------- -------------");
		}
		
		String sentence = "I like camera but battery is very bad and I like picture.";
		String[] sentences = sentence.split(" and| but | always| or |\\.");
		for(String sent : sentences) {
			System.out.println(sent);
		}
		
	}
	
}
