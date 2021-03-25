package com.model;

public class Result {
	private int resultId;
	private Call call;
	private String sentimentCategory;
	private float probability;
	private String aspectResult;

	public Result() {
		super();
	}

	public Result(Call call, String sentimentCategory, float probability, String aspectResult) {
		super();
		this.call = call;
		this.sentimentCategory = sentimentCategory;
		this.probability = probability;
		this.aspectResult = aspectResult;
	}

	/**
	 * @return the resultId
	 */
	public int getResultId() {
		return resultId;
	}

	/**
	 * @param resultId
	 *            the resultId to set
	 */
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	/**
	 * @return the call
	 */
	public Call getCall() {
		return call;
	}

	/**
	 * @param call
	 *            the call to set
	 */
	public void setCall(Call call) {
		this.call = call;
	}

	/**
	 * @return the sentimentCategory
	 */
	public String getSentimentCategory() {
		return sentimentCategory;
	}

	/**
	 * @param sentimentCategory
	 *            the sentimentCategory to set
	 */
	public void setSentimentCategory(String sentimentCategory) {
		this.sentimentCategory = sentimentCategory;
	}

	/**
	 * @return the probability
	 */
	public float getProbability() {
		return probability;
	}

	/**
	 * @param probability
	 *            the probability to set
	 */
	public void setProbability(float probability) {
		this.probability = probability;
	}

	/**
	 * @return the aspectResult
	 */
	public String getAspectResult() {
		return aspectResult;
	}

	/**
	 * @param aspectResult
	 *            the aspectResult to set
	 */
	public void setAspectResult(String aspectResult) {
		this.aspectResult = aspectResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Result [resultId=" + resultId + ", call=" + call + ", sentimentCategory=" + sentimentCategory
				+ ", probability=" + probability + ", aspectResult=" + aspectResult + "]";
	}

}
