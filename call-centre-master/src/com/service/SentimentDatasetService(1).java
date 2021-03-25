package com.service;

import java.util.List;

import com.model.SentimentDataset;

public interface SentimentDatasetService {
	public List<SentimentDataset> loadDataset();
	public List<String> getPositiveDataset();
	public List<String> getNegativeDataset();
}
