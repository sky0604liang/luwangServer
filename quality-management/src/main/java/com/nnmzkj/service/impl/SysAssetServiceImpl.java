package com.nnmzkj.service.impl;

import com.nnmzkj.dao.SysAssetMapper;
import com.nnmzkj.service.SysAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysAssetServiceImpl implements SysAssetService {

    @Autowired
    private SysAssetMapper sysAssetMapper;

    @Override
    public void deleteAsset(Long assetId) {
        sysAssetMapper.deleteByPrimaryKey(assetId);
    }
}
