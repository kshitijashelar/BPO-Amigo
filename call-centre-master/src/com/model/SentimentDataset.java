package com.model;

import java.util.List;

public class SentimentDataset {
	private String categoryName;
	private List<String> featureSet;

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName
	 *            the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the featureSet
	 */
	public List<String> getFeatureSet() {
		return featureSet;
	}

	/**
	 * @param featureSet
	 *            the featureSet to set
	 */
	public void setFeatureSet(List<String> featureSet) {
		this.featureSet = featureSet;
	}

	public SentimentDataset() {
		super();
		// TODO Auto-generated constructor stub
	}

}
