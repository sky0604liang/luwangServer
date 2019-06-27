package com.nnmzkj.service.impl;

import com.nnmzkj.dao.SystemLogMapper;
import com.nnmzkj.model.SystemLog;
import com.nnmzkj.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Autowired
    private SystemLogMapper systemLogMapper;

    @Override
    public void save(SystemLog sysLog) {
        systemLogMapper.insertSelective(sysLog);
    }
}
