package com.constant;

public interface Constant {
	/**
	 * AES ALGORITHM ENCRYPTION KEY
	 */
	public static final String ENCRYPTION_KEY = "callcentre@123";
	
	public static final String STOPWORD_DATASET_FILE = "C:/Users/DELL/Documents/workspace_new/call-centre-master/WebContent/sent_config/english";
	
	public static final String UPLOAD_AUDIO_FILE_PATH = "C:/Users/DELL/Documents/workspace_new/call-centre-master/WebContent/call_audio_file/";
	public static final String WORDNET_DICTIONARY_PATH = "C:/Users/DELL/Documents/workspace_new/call-centre-master/WebContent/config/";
	public static final String SLAG_WORD_DICTIONARY_PATH = "C:/Users/DELL/Documents/workspace_new/call-centre-master/WebContent/sent_config/";
	/**
	 * User Table column names
	 *
	 */
	public static final String TABLE_NAME_USER = "user";
	public static final String USER_ID = "u_id";
	public static final String FULL_NAME = "full_name";
	public static final String EMAIL_ID = "email_id";
	public static final String PASSWORD = "password";
	public static final String STATUS = "status";
	public static final String REGISTER_DATE = "reg_date";
	public static final String MOBILE_NUMBER = "mobile_number";
	public static final String USER_TYPE = "user_type";
	public static final String OTP = "otp";
	public static final String PRODUCT_NAME = "product_name";

	/**
	 * CALL Table column names here
	 */
	public static final String TABLE_NAME_CALL = "call_data";
	public static final String CALL_ID = "call_id";
	public static final String CALL_TEXT = "call_text";
	public static final String PROCCESSED_TEXT = "proccessed_text";
	public static final String AUDIO_FILE_PATH = "audio_file_path";
	public static final String CALL_ADD_DATE = "add_date";
	
	/**
	 * DATASET Table column name here
	 */
	public static final String TABLE_NAME_DATASET = "dataset"; 
	public static final String RECORD_ID = "record_id";
	public static final String CALL_TEXT_DATA = "call_text_data";
	public static final String CALL_PROCESSED_TEXT_DATA = "processed_text_data";
	public static final String CATEGORY_NAME = "category_name";
	
	public static final String TABLE_NAME_RESULT = "result";
	public static final String RESULT_ID = "result_id";
	public static final String SENTIMENT_CATEGORY = "sentiment_category";
	public static final String PROBABILITY = "probability";
	public static final String ASPECT_RESULT = "aspect_result";
	
}
