package com.nnmzkj.web.controller;


import com.github.pagehelper.PageInfo;
import com.nnmzkj.common.core.Result;
import com.nnmzkj.common.core.ResultGenerator;
import com.nnmzkj.config.log.MyLog;
import com.nnmzkj.dto.BaseListParameterDto;
import com.nnmzkj.model.QualityProApproval;
import com.nnmzkj.service.QualityProApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/approval")
public class QualityProApprovalController {

    @Autowired
    private QualityProApprovalService qualityProApprovalService;




    //项目审批列表
    @GetMapping("/list")
    public Result list(BaseListParameterDto baseListParameterDto){
        PageInfo list = qualityProApprovalService.list(baseListParameterDto);
        return ResultGenerator.genSuccessResult(list);
    }

    @MyLog(value = "新增批文")
    @PostMapping("/add")
    public void addProApproval(@RequestBody QualityProApproval qualityProApproval){
        qualityProApprovalService.addProApproval(qualityProApproval);
    }
}
