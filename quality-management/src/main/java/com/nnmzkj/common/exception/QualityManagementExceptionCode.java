package com.nnmzkj.common.exception;


import com.nnmzkj.common.core.QualityManagementExceptionMsg;

public enum QualityManagementExceptionCode {


	/**
	 * 异常测试
	 */
	EXCEPTION_TEST(new QualityManagementExceptionMsg("8000","异常统一抛出测试")),
	PAGE_IS_NULL(new QualityManagementExceptionMsg("8001","页码不能为空")),
	FILE_FORMAT_IS_ERROR(new QualityManagementExceptionMsg("8002","文件格式错误")),
	OBJECT_IS_MORE(new QualityManagementExceptionMsg("8003","项目名称重复")),
	OBJECT_NAME_IS_NULL(new QualityManagementExceptionMsg("8004","项目名称不能为空")),
	USER_PASSWORD_IS_ERROR(new QualityManagementExceptionMsg("8005","用户名或密码错误")),
	HAVE_IDENTICAL_USER(new QualityManagementExceptionMsg("8006","账户已存在")),
	USER_NAME_EXCEPTION(new QualityManagementExceptionMsg("8007","账户被禁用")),
	USER_NAME_IS_NULL(new QualityManagementExceptionMsg("8008","不存在这个账户")),
	PASSWORD_IS_ERROR(new QualityManagementExceptionMsg("8009","密码错误")),
	;

	private QualityManagementExceptionMsg message;

	private QualityManagementExceptionCode(QualityManagementExceptionMsg msg) {

		this.message = msg;
	}

	public QualityManagementExceptionMsg get() {
		return message;
	}

}
