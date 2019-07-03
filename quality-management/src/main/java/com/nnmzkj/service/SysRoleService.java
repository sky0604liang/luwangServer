package com.nnmzkj.service;

import com.github.pagehelper.PageInfo;
import com.nnmzkj.dto.BaseListParameterDto;

public interface SysRoleService {

    PageInfo selectSysRole(BaseListParameterDto pageMsg);
}
