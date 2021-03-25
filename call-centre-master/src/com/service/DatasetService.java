package com.service;

import java.util.List;

import com.model.Dataset;

public interface DatasetService {
	public boolean save(Dataset dataset);

	public List<Dataset> getAllTrainData();
	
	public boolean update(Dataset dataset);
}
