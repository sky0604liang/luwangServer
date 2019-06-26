package com.nnmzkj.common.core;

import java.io.Serializable;

public class QualityManagementExceptionMsg implements Serializable {

    private String errorCode;
    private String message;

    public QualityManagementExceptionMsg(String errorCode, String message) {
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
