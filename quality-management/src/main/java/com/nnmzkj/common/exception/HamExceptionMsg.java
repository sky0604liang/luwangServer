package com.nnmzkj.common.exception;

public class HamExceptionMsg {

	/**
	 * 异常编码（服务、模块内自行定义的异常编码）
	 */
	private String errorCode;
	/**
	 * 异常描述消息
	 */
	private String message;

	public HamExceptionMsg(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
