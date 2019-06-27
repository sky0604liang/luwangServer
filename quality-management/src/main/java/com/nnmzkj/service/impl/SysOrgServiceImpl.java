package com.nnmzkj.service.impl;

import com.nnmzkj.dao.SysOrgMapper;
import com.nnmzkj.model.SysOrg;
import com.nnmzkj.service.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysOrgServiceImpl implements SysOrgService {

    @Autowired
    private SysOrgMapper sysOrgMapper;


    @Override
    public List<SysOrg> getAllOrg() {
        List<SysOrg> list = sysOrgMapper.getAllOrg();
        return list;
    }
}
