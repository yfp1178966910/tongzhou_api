package com.combanc.cas.client.springboot.controller;

import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.entity.StudyNewsEntity;
import com.combanc.cas.client.springboot.entity.StudyNewsEntity;
import com.combanc.cas.client.springboot.enums.ActionEnum;
import com.combanc.cas.client.springboot.enums.ResultCode;
import com.combanc.cas.client.springboot.service.StudyNewsService;
import com.combanc.cas.client.springboot.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@RestController
@RequestMapping("/studyNews")
public class StudyNewsController {
    
    @Autowired
    private StudyNewsService studyNewsService;

    @ResponseBody
//    @IgnoreSecurity //忽略安全性检查
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Result create(StudyNewsEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        //userService.doCertification(request, ConstantUtils.USER_Researcher);
        data.setAction( ActionEnum.create.getCode());
        return studyNewsService.save(data);

    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Result update(StudyNewsEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        //userService.doCertification(request, ConstantUtils.USER_Researcher);
        if (StringUtils.isEmpty(data.getId()) ) {
            return Result.build(ResultCode.PARAM_ERROR, "invalid argument");
        }

        data.setAction(ActionEnum.update.getCode());
        return studyNewsService.save(data);

    }
        @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public Result delete(@RequestParam(value = "id",required = true) String id, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        //userService.doCertification(request, ConstantUtils.USER_Researcher);
        StudyNewsEntity data = new StudyNewsEntity();
        data.setId(id);
        data.setAction(ActionEnum.delete.getCode());
        return studyNewsService.save(data);

    }
    @ResponseBody
    @RequestMapping(value = "selectByPgList", method = RequestMethod.GET)
    public Result selectByPgList(StudyNewsEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        PageBean<StudyNewsEntity> byList = studyNewsService.findByPgList(data);
        return Result.success(byList);


    }

    @ResponseBody
    @RequestMapping(value = "selectById", method = RequestMethod.GET)
    public Result selectById(StudyNewsEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        if (StringUtils.isEmpty(data.getId()) ) {
            return Result.build(ResultCode.PARAM_ERROR, "invalid argument");
        }
        StudyNewsEntity byId = studyNewsService.findById(data.getId());
        return Result.success(byId);

    }

    @ResponseBody
    @RequestMapping(value = "read", method = RequestMethod.GET)
    public Result read(StudyNewsEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        return studyNewsService.read(data);

    }
}
