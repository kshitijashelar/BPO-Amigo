package com.model;

public class ComparisionProductResult {
	String productName;
	double probabilityValue;

	public ComparisionProductResult() {
		super();
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the probabilityValue
	 */
	public double getProbabilityValue() {
		return probabilityValue;
	}

	/**
	 * @param probabilityValue
	 *            the probabilityValue to set
	 */
	public void setProbabilityValue(double probabilityValue) {
		this.probabilityValue = probabilityValue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ComparisionProductResult [productName=" + productName + ", probabilityValue=" + probabilityValue + "]";
	}

	
}
