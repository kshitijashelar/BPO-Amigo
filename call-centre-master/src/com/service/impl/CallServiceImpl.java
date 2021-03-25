package com.service.impl;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.bouncycastle.crypto.prng.EntropySource;

import com.constant.Constant;
import com.database.Database;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.KeywordsResult;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeakerLabel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechAlternative;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Transcript;
import com.model.Call;
import com.model.User;
import com.service.CallService;
import com.service.UserService;

public class CallServiceImpl implements CallService, Constant {

	@Override
	public boolean save(Call call) {
		boolean isSave = false;
		try {
			String sql = "INSERT INTO " + TABLE_NAME_CALL + " ( " + CALL_ID + "," + CALL_TEXT + "," + PROCCESSED_TEXT
					+ "," + AUDIO_FILE_PATH + "," + CALL_ADD_DATE + "," + STATUS +","+USER_ID+ ") VALUES(?,?,?,?,?,?,?)";
			PreparedStatement statement = Database.getConnection().prepareStatement(sql);
			statement.setInt(1, call.getCallId());
			statement.setString(2, call.getCallText());
			statement.setString(3, call.getProcessesText());
			statement.setString(4, call.getAudioFilePath());
			statement.setString(5, call.getAddCallDate());
			statement.setInt(6, call.getStatus());
			statement.setInt(7, call.getUser().getUserId());
			int result = statement.executeUpdate();
			if (1 == result) {
				isSave = true;
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return isSave;
	}

	@Override
	public String voiceToText(File audioFile) {
		SpeechToText service = new SpeechToText();
		service.setUsernameAndPassword("2044ecc8-8803-4530-a93d-99a7b590a56b", "uaaYyy2Kup2o");
		// List<SpeechModel> models = service.getModels().execute();
		// System.out.println(models);

		RecognizeOptions options = new RecognizeOptions.Builder().contentType("audio/mp3").timestamps(true)
				.wordAlternativesThreshold(0.9)
				// .keywords(new String[]{"camera", "battery", "speaker","device"})
				// .keywordsThreshold(0.5)
				.build();

		// String[] files =
		// {"D:\\Spring\\sts-bundle\\2018\\BE\\call-centre-master\\WebContent\\call_audio_file\\E4.mp3"};
		// for (String file : files) {
		// SpeechResults results = service.recognize(new File(file), options).execute();
		// System.out.println(results);
		// }
		//
		SpeechResults results = service.recognize(audioFile, options).execute();
		String result = results.getResults().toString();
		// System.out.println("Result :: "+result);
		List<Transcript> transcripts = results.getResults();
		StringBuilder voiceTextResult = new StringBuilder();
		for (Transcript transcript : transcripts) {
			List<SpeechAlternative> speechAlternatives = transcript.getAlternatives();
			for (SpeechAlternative speechAlternative : speechAlternatives) {
				String transcriptText = speechAlternative.getTranscript();
				// System.out.println("Script :: "+transcriptText);
				voiceTextResult.append(transcriptText).append("\n");
			}
		}
		return voiceTextResult.toString();
	}

	@Override
	public Call findByCallId(int callId) {
		Call call = null;
		try {
			String sql = "SELECT * FROM " + TABLE_NAME_CALL + " WHERE " + CALL_ID + "=?";
			PreparedStatement statement = Database.getConnection().prepareStatement(sql);
			statement.setInt(1, callId);
			ResultSet result = statement.executeQuery();
			UserService userService = new UserServiceImpl();
			while (result.next()) {
				call = new Call();
				call.setCallId(result.getInt(CALL_ID));
				call.setCallText(result.getString(CALL_TEXT));
				call.setProcessesText(result.getString(PROCCESSED_TEXT));
				call.setStatus(result.getInt(STATUS));
				call.setAudioFilePath(result.getString(AUDIO_FILE_PATH));
				call.setAddCallDate(result.getString(CALL_ADD_DATE));
                call.setUser(userService.findByUserId(result.getInt(USER_ID)));
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return call;
	}

	


	@Override
	public List<User> findDistinctUser() {
		List<User> users = null;
		try {
			String sql = "SELECT DISTINCT(" + USER_ID + ") FROM " + TABLE_NAME_CALL;
			PreparedStatement statement = Database.getConnection().prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			UserService userService = new UserServiceImpl();
			users = new ArrayList<>();
			while (result.next()) {
				int userId = result.getInt(USER_ID);
				User user = userService.findByUserId(userId);
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return users;
	}

	@Override
	public List<Call> findByUser(int userId) {
		List<Call> calls = new ArrayList<>();
		try {
			String sql = "SELECT * FROM " + TABLE_NAME_CALL + " WHERE " + USER_ID + "=?";
			PreparedStatement statement = Database.getConnection().prepareStatement(sql);
			statement.setInt(1, userId);
			ResultSet result = statement.executeQuery();
			UserService userService = new UserServiceImpl();
			while (result.next()) {
				Call call = new Call();
				call.setCallId(result.getInt(CALL_ID));
				call.setCallText(result.getString(CALL_TEXT));
				call.setProcessesText(result.getString(PROCCESSED_TEXT));
				call.setStatus(result.getInt(STATUS));
				call.setAudioFilePath(result.getString(AUDIO_FILE_PATH));
				call.setAddCallDate(result.getString(CALL_ADD_DATE));
                call.setUser(userService.findByUserId(result.getInt(USER_ID)));
                calls.add(call);
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return calls;
	}

}
