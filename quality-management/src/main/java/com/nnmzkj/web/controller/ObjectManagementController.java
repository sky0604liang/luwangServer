package com.nnmzkj.web.controller;


import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.nnmzkj.common.core.PageMsg;
import com.nnmzkj.common.core.Result;
import com.nnmzkj.common.core.ResultGenerator;
import com.nnmzkj.common.exception.QualityManagementException;
import com.nnmzkj.common.exception.QualityManagementExceptionCode;
import com.nnmzkj.config.log.MyLog;
import com.nnmzkj.dto.AddManagementDto;
import com.nnmzkj.service.ObjectManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/object/management")
public class ObjectManagementController {

    @Autowired
    private ObjectManagementService objectManagementService;

    //项目管理列表
    @GetMapping("/list")
    public PageInfo getManagementList(PageMsg pageMsg){
        if (StringUtils.isEmpty(pageMsg)){
            throw new QualityManagementException(QualityManagementExceptionCode.PAGE_IS_NULL);
        }
        PageInfo list = objectManagementService.getManagementList(pageMsg);
        return  list;
    }

    @MyLog(value = "新增项目")  //这里添加了AOP的自定义注解
    //新增项目管理
    @PostMapping("/add/object")
    public Result addObject(AddManagementDto addManagementDto){
        if (StringUtils.isEmpty(addManagementDto) && StringUtil.isNotEmpty(addManagementDto.getProName())){
            throw new QualityManagementException(QualityManagementExceptionCode.OBJECT_NAME_IS_NULL);
        }
        objectManagementService.addObject(addManagementDto);
        return ResultGenerator.genSuccessResult();
    }

}
