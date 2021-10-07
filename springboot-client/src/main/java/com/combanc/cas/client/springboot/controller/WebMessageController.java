package com.combanc.cas.client.springboot.controller;

import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.entity.WebMessageEntity;
import com.combanc.cas.client.springboot.enums.ActionEnum;
import com.combanc.cas.client.springboot.enums.ResultCode;
import com.combanc.cas.client.springboot.service.WebMessageService;
import com.combanc.cas.client.springboot.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/webMessage")
public class WebMessageController {
    @Autowired
    private WebMessageService webMessageService;

    @ResponseBody
//    @IgnoreSecurity //忽略安全性检查
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Result create(WebMessageEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        if (StringUtils.isEmpty(data.getUserId())){
            return Result.build(ResultCode.PARAM_ERROR, "invalid argument");
        }
        //userService.doCertification(request, ConstantUtils.USER_Researcher);
        data.setAction( ActionEnum.create.getCode());
        return webMessageService.save(data);

    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Result update(WebMessageEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        //userService.doCertification(request, ConstantUtils.USER_Researcher);
        if (StringUtils.isEmpty(data.getId())) {
            return Result.build(ResultCode.PARAM_ERROR, "invalid argument");
        }
        data.setAction(ActionEnum.update.getCode());
        return webMessageService.save(data);

    }
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public Result delete(WebMessageEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        //userService.doCertification(request, ConstantUtils.USER_Researcher);
            if (StringUtils.isEmpty(data.getId()) || StringUtils.isEmpty(data.getUserId())) {
                return Result.build(ResultCode.PARAM_ERROR, "invalid argument");
            }
        data.setAction(ActionEnum.delete.getCode());
        return webMessageService.save(data);

    }


    @ResponseBody
    @RequestMapping(value = "deleteById", method = RequestMethod.POST)
    public Result deleteById(WebMessageEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        //userService.doCertification(request, ConstantUtils.USER_Researcher);
        if (StringUtils.isEmpty(data.getId()) ) {
            return Result.build(ResultCode.PARAM_ERROR, "invalid argument");
        }
        int i = webMessageService.deleteById(data.getId());
        return Result.success("Effected  "+i+"  row.");

    }
    @ResponseBody
    @RequestMapping(value = "selectByPgList", method = RequestMethod.GET)
    public Result selectByPgList(WebMessageEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        PageBean<WebMessageEntity> byList = webMessageService.findByPgList(data);
        return Result.success(byList);


    }
    @ResponseBody
    @RequestMapping(value = "selectByList", method = RequestMethod.GET)
    public Result selectByList(WebMessageEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        return webMessageService.findByList(data);

    }

    @ResponseBody
    @RequestMapping(value = "getStates", method = RequestMethod.GET)
    public Result getStates(WebMessageEntity data, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        if (StringUtils.isEmpty(data.getId()) || StringUtils.isEmpty(data.getUserId())) {
            return Result.build(ResultCode.PARAM_ERROR, "invalid argument");
        }

        int states = webMessageService.getStates(data);
        return Result.success(states);
    }

    @ResponseBody
    @RequestMapping(value = "changeStates", method = RequestMethod.POST)
    public Result changeStates(WebMessageEntity data, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        if (StringUtils.isEmpty(data.getId()) || StringUtils.isEmpty(data.getUserId())) {
            return Result.build(ResultCode.PARAM_ERROR, "invalid argument");
        }

        return webMessageService.changeStates(data);
    }


    @ResponseBody
    @RequestMapping(value = "getMessages", method = RequestMethod.GET)
    public Result getMessages(WebMessageEntity data, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        if ( StringUtils.isEmpty(data.getUserId())) {
            return Result.build(ResultCode.PARAM_ERROR, "invalid argument");
        }

        PageBean<WebMessageEntity> list = webMessageService.getMessages(data);
        return Result.success(list);
    }
    @ResponseBody
    @RequestMapping(value = "changeAllMessages", method = RequestMethod.GET)
    public Result changeAllMessages(WebMessageEntity data, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        if ( StringUtils.isEmpty(data.getUserId())) {
            return Result.build(ResultCode.PARAM_ERROR, "invalid argument");
        }

        return webMessageService.changeAllMessages(data);
    }

    }
