package com.nnmzkj.web.controller;


import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.nnmzkj.common.core.Result;
import com.nnmzkj.common.core.ResultGenerator;
import com.nnmzkj.config.log.MyLog;
import com.nnmzkj.dto.BaseListParameterDto;
import com.nnmzkj.model.QualityPreparation;
import com.nnmzkj.service.ProjectPreparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preparation")
public class ProjectPreparationController {


    @Autowired
    private ProjectPreparationService projectPreparationService;

    //获取项目筹备列表
    @GetMapping("/list")
    public Result list(BaseListParameterDto baseListParameterDto){
        PageInfo list = projectPreparationService.list(baseListParameterDto);
        return ResultGenerator.genSuccessResult(list);
    }


    @MyLog(value = "新增筹备材料")
    @PostMapping("/add")
    public void addPreparationInfo(@RequestBody QualityPreparation qualityPreparation){
        projectPreparationService.addPreparationInfo(qualityPreparation);
    }


    @MyLog(value = "编辑筹备材料")
    @PostMapping("/update")
    public void updatePreparationInfo(@RequestBody QualityPreparation qualityPreparation){
        projectPreparationService.updatePreparationInfo(qualityPreparation);
    }

    //跳转编辑/新增页面
    @GetMapping("/to/add")
    public Result toAddPreparationInfo(Long proId){
        if (!StringUtils.isEmpty(proId)){
            //有筹备材料
         List<QualityPreparation> list=projectPreparationService.toAddPreparationInfo(proId);
            return ResultGenerator.genSuccessResult(list);
        }
        return ResultGenerator.genSuccessResult();
    }
}
