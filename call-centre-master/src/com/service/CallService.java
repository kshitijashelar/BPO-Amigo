package com.service;

import java.io.File;
import java.util.List;

import com.model.Call;
import com.model.User;

public interface CallService {
	public boolean save(Call call);
	
	public String voiceToText(File audioFile);
	
	public Call findByCallId(int callId);
	
	public List<User> findDistinctUser();
	
	public List<Call> findByUser(int userId);
}
