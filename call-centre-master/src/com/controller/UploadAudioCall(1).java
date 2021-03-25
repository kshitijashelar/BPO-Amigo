package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.constant.Constant;
import com.constant.ConstantMethod;
import com.service.CallService;
import com.service.impl.CallServiceImpl;

/**
 * Servlet implementation class UploadAudioCall
 */
@WebServlet("/UploadAudioCall")
public class UploadAudioCall extends HttpServlet implements Constant {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	RequestDispatcher rd;
	String url_path;
	File savedFile;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadAudioCall() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession(true);
		url_path = "./AddAudioCall";
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
		} else {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<?> items = null;
			String itemName = null;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			Iterator<?> itr = items.iterator();
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				if (item.isFormField()) {
					System.out.println("Form Field");

				} else {
					try {
						itemName = ConstantMethod.getRandomNumber() + "_" + ConstantMethod.getCurrentDate() + ".mp3";
						savedFile = new File(UPLOAD_AUDIO_FILE_PATH + itemName);
						item.write(savedFile);
						System.out.println("File Absolute Path :" + savedFile.getAbsolutePath());
						System.out.println("URL PATH : " + url_path);
					} catch (Exception ex) {
						url_path = "./add_audio_call.jsps";
						System.err.println(ex.getMessage());
						session.setAttribute("msg", "Somthing is wrong!!..");
						session.setAttribute("flag", "0");
					}
				}
			} // end while loop

			CallService callService = new CallServiceImpl();
			String voiceToText = callService.voiceToText(savedFile);
			System.out.println("Voice To Text :: "+voiceToText);
			request.setAttribute("call_data_text", voiceToText);
			request.setAttribute("fileName", savedFile.getName());
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
