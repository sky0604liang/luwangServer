package com.nnmzkj.common.exception;



import java.text.MessageFormat;



public class QualityManagementException extends SoftException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QualityManagementException(QualityManagementExceptionCode code) {
		super(code.get().getErrorCode(), code.get().getMessage());
	}

	public QualityManagementException(QualityManagementExceptionCode code, Object... format) {
		super(code.get().getErrorCode(), MessageFormat.format(code.get().getMessage(), format));
	}
}
