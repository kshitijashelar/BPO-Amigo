package com.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.constant.Constant;
import com.database.Database;
import com.model.Dataset;
import com.service.DatasetService;

public class DatasetServiceImpl implements Constant, DatasetService {

	@Override
	public boolean save(Dataset dataset) {
		boolean isSave = false;
		try {
			String sql = "INSERT INTO " + TABLE_NAME_DATASET + " ( " + CALL_TEXT_DATA + "," + CALL_PROCESSED_TEXT_DATA + ","
					+ CATEGORY_NAME + ") VALUES(?,?,?)";
			PreparedStatement statement = Database.getConnection().prepareStatement(sql);
			statement.setString(1, dataset.getCallTextData());
			statement.setString(2, dataset.getProcessedTextData());
			statement.setString(3, dataset.getCategoryName());
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
	public List<Dataset> getAllTrainData() {
		List<Dataset> trainDataset = new ArrayList<>();
		try {
			String sql = "SELECT * FROM " + TABLE_NAME_DATASET;
			PreparedStatement statement = Database.getConnection().prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Dataset dataset = new Dataset();
				dataset.setRecordId(result.getInt(RECORD_ID));
				dataset.setCallTextData(result.getString(CALL_TEXT_DATA));
				dataset.setProcessedTextData(result.getString(CALL_PROCESSED_TEXT_DATA));
				dataset.setCategoryName(result.getString(CATEGORY_NAME));
				trainDataset.add(dataset);
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return trainDataset;
	}

	@Override
	public boolean update(Dataset dataset) {
		boolean isUpdate = false;
		try {
			String sql = "UPDATE "+TABLE_NAME_DATASET+" SET "+CALL_PROCESSED_TEXT_DATA+"=? WHERE "+RECORD_ID+"=?";
			PreparedStatement statement = Database.getConnection().prepareStatement(sql);
			statement.setString(1, dataset.getProcessedTextData());
			statement.setInt(2, dataset.getRecordId());
			int result = statement.executeUpdate();
			if(1 == result) {
				isUpdate = true;
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return isUpdate;
	}

}
