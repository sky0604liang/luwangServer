package com.nnmzkj.common.exception;


import com.nnmzkj.common.core.QualityManagementExceptionMsg;

public enum QualityManagementExceptionCode {


	/**
	 * 统一处理异常
	 */
	ALIPAY_PAY_ERROR(new QualityManagementExceptionMsg("编码","xxx错误"));

	private QualityManagementExceptionMsg message;

	private QualityManagementExceptionCode(QualityManagementExceptionMsg msg) {

		this.message = msg;
	}

	public QualityManagementExceptionMsg get() {
		return message;
	}

}
