package com.nnmzkj.common.exception;

/**
 * 错误消息封装类
 * 
 * @author lining
 *
 */
public class SoftException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 错误码
	 */
	private final String errorCode;
	
	public SoftException() {
		super();
		this.errorCode = "";
	}

	public SoftException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public SoftException(String errorCode, String message, Throwable e) {
		super(message, e);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
