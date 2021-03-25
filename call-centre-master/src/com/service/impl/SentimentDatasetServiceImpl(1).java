package com.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.database.Database;
import com.model.SentimentDataset;
import com.service.SentimentDatasetService;

public class SentimentDatasetServiceImpl implements SentimentDatasetService {

	@Override
	public List<SentimentDataset> loadDataset() {
		List<SentimentDataset> sentimentDatasets = new ArrayList<SentimentDataset>();
		SentimentDataset sentimentDataset1 = new SentimentDataset();
		sentimentDataset1.setCategoryName("Positive");
		sentimentDataset1.setFeatureSet(getPositiveDataset());

		SentimentDataset sentimentDataset2 = new SentimentDataset();
		sentimentDataset2.setCategoryName("Negative");
		sentimentDataset2.setFeatureSet(getNegativeDataset());

		sentimentDatasets.add(sentimentDataset1);
		sentimentDatasets.add(sentimentDataset2);
		return sentimentDatasets;
	}

	@Override
	public List<String> getPositiveDataset() {
		List<String> dataset = new ArrayList<String>();
		try {
			String sql = "SELECT * FROM positive_keywords";
			PreparedStatement statement = Database.getConnection().prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				dataset.add(result.getString("words"));
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return dataset;
	}

	@Override
	public List<String> getNegativeDataset() {
		List<String> dataset = new ArrayList<String>();
		try {
			String sql = "SELECT * FROM negative_keywords";
			PreparedStatement statement = Database.getConnection().prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				dataset.add(result.getString("words"));
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return dataset;
	}

}
