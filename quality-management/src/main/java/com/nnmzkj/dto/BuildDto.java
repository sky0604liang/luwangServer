package com.nnmzkj.dto;

import java.io.Serializable;

public class BuildDto implements Serializable {
    private static final long serialVersionUID = -6258514019483071163L;

    private String buildName;

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }
}
