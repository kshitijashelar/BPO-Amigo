package com.service;

import java.util.List;


import com.model.Result;

public interface ResultService {
	public boolean save(Result result);

	public Result findByResultId(int resultId);

	public List<Result> findAllResult();
	
	public List<Result> findAllResult(int userId);
	
	public List<Result> findByAspectResult(int userId,List<String> aspectNames);
}
