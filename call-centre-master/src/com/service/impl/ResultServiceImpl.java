package com.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.constant.Constant;
import com.database.Database;
import com.model.Call;
import com.model.Result;
import com.service.CallService;
import com.service.ResultService;

public class ResultServiceImpl implements ResultService, Constant {

	@Override
	public boolean save(Result result) {
		boolean save = false;
		try {
			String sql = "INSERT INTO " + TABLE_NAME_RESULT + " ( " + CALL_ID + ", " + SENTIMENT_CATEGORY + ","
					+ PROBABILITY + "," + ASPECT_RESULT + ") VALUES(?,?,?,?)";
			PreparedStatement statement = Database.getConnection().prepareStatement(sql);
			statement.setInt(1, result.getCall().getCallId());
			statement.setString(2, result.getSentimentCategory());
			statement.setFloat(3, result.getProbability());
			statement.setString(4, result.getAspectResult());
			int resultSet = statement.executeUpdate();
			if (1 == resultSet) {
				save = true;
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return save;
	}

	@Override
	public Result findByResultId(int resultId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Result> findAllResult() {
		List<Result> results = new ArrayList<Result>();
		try {
			String sql = "SELECT * FROM " + TABLE_NAME_RESULT;
			PreparedStatement statement = Database.getConnection().prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			CallService callService = new CallServiceImpl();
			while (result.next()) {
				Result resultDb = new Result();
				resultDb.setAspectResult(result.getString(ASPECT_RESULT));
				resultDb.setProbability(result.getFloat(PROBABILITY));
				resultDb.setSentimentCategory(result.getString(SENTIMENT_CATEGORY));
				resultDb.setResultId(result.getInt(RESULT_ID));
				resultDb.setCall(callService.findByCallId(result.getInt(CALL_ID)));
				results.add(resultDb);
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return results;
	}

	/**
	 * select * from call_data,result WHERE call_data.call_id=result.call_id AND
	 * call_data.u_id=11 and ( result.aspect_result like '%camera%' OR
	 * result.aspect_result like '%bluetooth%')
	 * 
	 */
	@Override
	public List<Result> findByAspectResult(int userId, List<String> aspectNames) {
		List<Result> results = null;
		try {
			String tempSql = "SELECT * FROM " + TABLE_NAME_CALL + "," + TABLE_NAME_RESULT + " WHERE " + TABLE_NAME_CALL
					+ "." + CALL_ID + "=" + TABLE_NAME_RESULT + "." + CALL_ID + " AND " + TABLE_NAME_CALL + "."
					+ USER_ID + "=? AND (";
			StringBuilder builder = new StringBuilder();
			int counter = 0;
			for (String aspectName : aspectNames) {
				builder.append(TABLE_NAME_RESULT).append(".").append(ASPECT_RESULT).append(" LIKE ").append("'%" + aspectName + "%'");
				if (counter != aspectNames.size() - 1) {
					builder.append(" OR ");
				}
				counter++;
			}
			builder.append(")");
			String sql = tempSql + builder.toString();
//			System.out.println("SQL :: "+sql);
			PreparedStatement statement = Database.getConnection().prepareStatement(sql);
			statement.setInt(1, userId);
			ResultSet result = statement.executeQuery();
			results = new ArrayList<>();
			CallService callService = new CallServiceImpl();
			while (result.next()) {
				Result res = new Result();
				Call call = callService.findByCallId(result.getInt(CALL_ID));
				res.setCall(call);
                res.setAspectResult(result.getString(ASPECT_RESULT));
                res.setProbability(result.getFloat(PROBABILITY));
                res.setResultId(result.getInt(RESULT_ID));
                res.setSentimentCategory(result.getString(SENTIMENT_CATEGORY));
                results.add(res);
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return results;
	}

	@Override
	public List<Result> findAllResult(int userId) {
		List<Result> results = new ArrayList<Result>();
		try {
			String sql = "select * from call_data,result where call_data.call_id= result.call_id and call_data.u_id=?";
			PreparedStatement statement = Database.getConnection().prepareStatement(sql);
			statement.setInt(1, userId);
			ResultSet result = statement.executeQuery();
			CallService callService = new CallServiceImpl();
			while (result.next()) {
				Result resultDb = new Result();
				resultDb.setAspectResult(result.getString(ASPECT_RESULT));
				resultDb.setProbability(result.getFloat(PROBABILITY));
				resultDb.setSentimentCategory(result.getString(SENTIMENT_CATEGORY));
				resultDb.setResultId(result.getInt(RESULT_ID));
				resultDb.setCall(callService.findByCallId(result.getInt(CALL_ID)));
				results.add(resultDb);
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return results;
	}

}
