package com.model;

public class Call {
	private int callId;
	private String callText;
	private String processesText;
	private String addCallDate;
	private String audioFilePath;
	private int status;
	private User user;

	public Call() {
		super();
	}

	public Call(String callText, String processesText, String addCallDate, String audioFilePath, int status) {
		super();
		this.callText = callText;
		this.processesText = processesText;
		this.addCallDate = addCallDate;
		this.audioFilePath = audioFilePath;

		this.status = status;
	}

	/**
	 * @return the callId
	 */
	public int getCallId() {
		return callId;
	}

	/**
	 * @param callId
	 *            the callId to set
	 */
	public void setCallId(int callId) {
		this.callId = callId;
	}

	/**
	 * @return the callText
	 */
	public String getCallText() {
		return callText;
	}

	/**
	 * @param callText
	 *            the callText to set
	 */
	public void setCallText(String callText) {
		this.callText = callText;
	}

	/**
	 * @return the processesText
	 */
	public String getProcessesText() {
		return processesText;
	}

	/**
	 * @param processesText
	 *            the processesText to set
	 */
	public void setProcessesText(String processesText) {
		this.processesText = processesText;
	}

	/**
	 * @return the addCallDate
	 */
	public String getAddCallDate() {
		return addCallDate;
	}

	/**
	 * @param addCallDate
	 *            the addCallDate to set
	 */
	public void setAddCallDate(String addCallDate) {
		this.addCallDate = addCallDate;
	}

	/**
	 * @return the audioFilePath
	 */
	public String getAudioFilePath() {
		return audioFilePath;
	}

	/**
	 * @param audioFilePath
	 *            the audioFilePath to set
	 */
	public void setAudioFilePath(String audioFilePath) {
		this.audioFilePath = audioFilePath;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Call [callId=" + callId + ", callText=" + callText + ", processesText=" + processesText
				+ ", addCallDate=" + addCallDate + ", audioFilePath=" + audioFilePath + ", status=" + status + ", user="
				+ user.toString() + "]";
	}

}
