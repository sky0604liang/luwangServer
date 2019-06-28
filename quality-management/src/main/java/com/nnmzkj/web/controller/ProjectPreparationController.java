package com.nnmzkj.web.controller;


import com.github.pagehelper.PageInfo;
import com.nnmzkj.common.core.Result;
import com.nnmzkj.common.core.ResultGenerator;
import com.nnmzkj.dto.BaseListParameterDto;
import com.nnmzkj.service.ProjectPreparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/preparation")
public class ProjectPreparationController {


    @Autowired
    private ProjectPreparationService projectPreparationService;

    //获取项目筹备列表
    @PostMapping("/list")
    public Result list(@RequestBody BaseListParameterDto baseListParameterDto){
        PageInfo list = projectPreparationService.list(baseListParameterDto);
        return ResultGenerator.genSuccessResult(list);
    }

    //新增筹备材料
    @PostMapping("/add")
    public void addPreparationInfo(){

    }
}
