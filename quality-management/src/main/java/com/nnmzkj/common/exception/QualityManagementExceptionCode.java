package com.nnmzkj.common.exception;


import com.nnmzkj.common.core.QualityManagementExceptionMsg;

public enum QualityManagementExceptionCode {


	/**
	 * 异常测试
	 */
	EXCEPTION_TEST(new QualityManagementExceptionMsg("8000","异常统一抛出测试")),
	PAGE_IS_NULL(new QualityManagementExceptionMsg("8001","页码不能为空")),
	OBJECT_NAME_IS_NULL(new QualityManagementExceptionMsg("8002","项目名称不能为空")),
	FILE_PATH_IS_NULL(new QualityManagementExceptionMsg("8003","指定的文件路径不存在"))
	;

	private QualityManagementExceptionMsg message;

	private QualityManagementExceptionCode(QualityManagementExceptionMsg msg) {

		this.message = msg;
	}

	public QualityManagementExceptionMsg get() {
		return message;
	}

}
