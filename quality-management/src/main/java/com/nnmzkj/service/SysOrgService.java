package com.nnmzkj.service;

import com.nnmzkj.model.SysOrg;

import java.util.List;
import java.util.Map;

public interface SysOrgService {


    List<SysOrg> getAllOrg();

    List<Map<String, Object>> getSysOrgSelect();
}
