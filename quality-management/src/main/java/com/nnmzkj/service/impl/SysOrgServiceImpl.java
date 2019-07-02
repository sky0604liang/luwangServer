package com.nnmzkj.service.impl;

import com.nnmzkj.dao.SysOrgMapper;
import com.nnmzkj.model.SysOrg;
import com.nnmzkj.service.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysOrgServiceImpl implements SysOrgService {

    @Autowired
    private SysOrgMapper sysOrgMapper;


    @Override
    public List<SysOrg> getAllOrg() {
        List<SysOrg> list = sysOrgMapper.getAllOrg();
        return list;
    }

    @Override
    public List<Map<String, Object>> getSysOrgSelect() {
        List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
        List<SysOrg> list = sysOrgMapper.getAllOrg();
        for (SysOrg sysOrg : list) {
            Map<String,Object> obj = new HashMap<String,Object>();
            obj.put("buildName", sysOrg.getName());
            obj.put("buildId", sysOrg.getOrgId());
            result.add(obj);
        }
        return result;
    }
}
