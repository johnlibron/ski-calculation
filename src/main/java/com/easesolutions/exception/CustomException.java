package com.easesolutions.exception;

public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
	public CustomException() {
		super();
	}
	public CustomException(Exception e) {
		super(e);
	}
	public CustomException(String errorMessage, Throwable cause, String errorCode) {
		super(errorMessage, cause);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	public CustomException(String errorMessage, String errorCode) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	public CustomException(Throwable cause, String errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}
	public CustomException(String errorCode, Exception e) {
		super(e);
		this.errorCode = errorCode;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}