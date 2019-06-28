package com.nnmzkj.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nnmzkj.dao.QualityProApprovalMapper;
import com.nnmzkj.dto.BaseListParameterDto;
import com.nnmzkj.dto.QualityProApprovalListDto;
import com.nnmzkj.model.QualityProApproval;
import com.nnmzkj.service.QualityProApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
public class QualityProApprovalServiceImpl implements QualityProApprovalService {

    @Autowired
    private QualityProApprovalMapper qualityProApprovalMapper;

    private final Integer COMPLETE_STATUS = 3;

    @Override
    public PageInfo list(BaseListParameterDto baseListParameterDto) {
        PageHelper.startPage(baseListParameterDto.getPage(),baseListParameterDto.getSize());
        List<QualityProApprovalListDto> list =qualityProApprovalMapper.list(baseListParameterDto.getBuildId());
        if (!StringUtils.isEmpty(list) && list.size() > 0){
            for (QualityProApprovalListDto qualityProApprovalListDto : list) {
                //通过项目id获取当前项目下所有的审批材料/所有的[已经完成]审批材料
                int allCount = qualityProApprovalMapper.getAllList(qualityProApprovalListDto.getProId(),null);
                //通过项目id获取当前项目下
                int completeCount = qualityProApprovalMapper.getAllList(qualityProApprovalListDto.getProId(),COMPLETE_STATUS);
                qualityProApprovalListDto.setProgress(String.valueOf(completeCount)+"/"+String.valueOf(allCount));
            }
        }
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public void addProApproval(QualityProApproval qualityProApproval) {
        MultipartFile blFile = qualityProApproval.getBlFile();
        //上传文件且文件不为空
        if (!StringUtils.isEmpty(qualityProApproval) && blFile != null && !blFile.isEmpty()){

        }

      //qualityProApprovalMapper.insertSelective(qualityProApproval);
    }
}
