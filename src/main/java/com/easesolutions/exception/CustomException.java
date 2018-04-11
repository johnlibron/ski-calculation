package com.easesolutions.exception;

import javax.servlet.http.HttpServletResponse;

import com.easesolutions.util.Constant;

public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private int errorCode;
	private String errorMessage;
	public CustomException() {
		super();
	}
	public CustomException(Exception e) {
		super(e);
	}
	public CustomException(String errorMessage, Throwable cause, int errorCode) {
		super(errorMessage, cause);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	public CustomException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = "[" + Constant.ERROR + "] " + errorMessage;
		this.errorCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
	}
	public CustomException(Throwable cause, int errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}
	public CustomException(int errorCode, Exception e) {
		super(e);
		this.errorCode = errorCode;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}