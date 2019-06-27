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
	OBJECT_NAME_IS_NULL(new QualityManagementExceptionMsg("8004","项目名称不能为空"))
	;

	private QualityManagementExceptionMsg message;

	private QualityManagementExceptionCode(QualityManagementExceptionMsg msg) {

		this.message = msg;
	}

	public QualityManagementExceptionMsg get() {
		return message;
	}

}
