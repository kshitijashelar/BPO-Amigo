package com.model;

public class Dataset {
	private int recordId;
	private String callTextData;
	private String processedTextData;
	private String categoryName;
	public Dataset() {
		super();
	}
	public Dataset(String callTextData, String processedTextData, String categoryName) {
		super();
		this.callTextData = callTextData;
		this.processedTextData = processedTextData;
		this.categoryName = categoryName;
	}
	/**
	 * @return the recordId
	 */
	public int getRecordId() {
		return recordId;
	}
	/**
	 * @param recordId the recordId to set
	 */
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	/**
	 * @return the callTextData
	 */
	public String getCallTextData() {
		return callTextData;
	}
	/**
	 * @param callTextData the callTextData to set
	 */
	public void setCallTextData(String callTextData) {
		this.callTextData = callTextData;
	}
	/**
	 * @return the processedTextData
	 */
	public String getProcessedTextData() {
		return processedTextData;
	}
	/**
	 * @param processedTextData the processedTextData to set
	 */
	public void setProcessedTextData(String processedTextData) {
		this.processedTextData = processedTextData;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dataset [recordId=" + recordId + ", callTextData=" + callTextData + ", processedTextData="
				+ processedTextData + ", categoryName=" + categoryName + "]";
	}
	
	
}
