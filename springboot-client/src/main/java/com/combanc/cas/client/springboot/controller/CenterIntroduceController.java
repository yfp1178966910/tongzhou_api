package com.combanc.cas.client.springboot.controller;

import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.entity.CenterIntroduceEntity;
import com.combanc.cas.client.springboot.enums.ActionEnum;
import com.combanc.cas.client.springboot.enums.ResultCode;
import com.combanc.cas.client.springboot.service.CenterIntroduceService;
import com.combanc.cas.client.springboot.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = {"/centerIntroduce", "/applets/centerIntroduce"})
public class CenterIntroduceController {
    @Autowired
    private CenterIntroduceService centerIntroduceService;

    @ResponseBody
//    @IgnoreSecurity //忽略安全性检查
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Result create(CenterIntroduceEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        //userService.doCertification(request, ConstantUtils.USER_Researcher);
        data.setAction( ActionEnum.create.getCode());
        return centerIntroduceService.save(data);

    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Result update(CenterIntroduceEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        //userService.doCertification(request, ConstantUtils.USER_Researcher);
        if (StringUtils.isEmpty(data.getId()) ) {
            return Result.build(ResultCode.PARAM_ERROR, "invalid argument");
        }

        data.setAction(ActionEnum.update.getCode());
        return centerIntroduceService.save(data);

    }
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public Result delete(@RequestParam(value = "id",required = true) String id, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        //userService.doCertification(request, ConstantUtils.USER_Researcher);
        CenterIntroduceEntity data = new CenterIntroduceEntity();
        data.setId(id);
        data.setAction(ActionEnum.delete.getCode());
        return centerIntroduceService.save(data);

    }
    @ResponseBody
    @RequestMapping(value = "selectByPgList", method = RequestMethod.GET)
    public Result selectByPgList(CenterIntroduceEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        PageBean<CenterIntroduceEntity> byList = centerIntroduceService.findByPgList(data);
        return Result.success(byList);


    }

    @ResponseBody
    @RequestMapping(value = "selectById", method = RequestMethod.GET)
    public Result selectById(CenterIntroduceEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        if (StringUtils.isEmpty(data.getId()) ) {
            return Result.build(ResultCode.PARAM_ERROR, "invalid argument");
        }
        CenterIntroduceEntity byId = centerIntroduceService.findById(data.getId());
        return Result.success(byId);

    }
    
    
}
