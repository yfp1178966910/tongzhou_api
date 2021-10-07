package com.combanc.cas.client.springboot.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.combanc.cas.client.springboot.configuration.CasconfigProperties;
import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.entity.SignUpEntity;
import com.combanc.cas.client.springboot.entity.UserEntity;
import com.combanc.cas.client.springboot.enums.ActionEnum;
import com.combanc.cas.client.springboot.enums.ResultCode;
import com.combanc.cas.client.springboot.service.UserService;
import com.combanc.cas.client.springboot.utils.Commons;
import com.combanc.cas.client.springboot.utils.ConstantUtils;
import com.combanc.cas.client.springboot.utils.PageBean;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private CasconfigProperties casconfigProperties;


    @Autowired
    private UserService userService;



    @GetMapping(value = "/login")
    @ResponseBody
    public Result login(HttpServletRequest request,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "/https://sso.bjtzeduyun.com/");//设置跨域允许

        //登陆失败
        if (request.getUserPrincipal() == null) {
            logger.info("request_info:" + JSONUtils.toJSONString(request));
            return Result.failed("登陆无法获取用户角色");
        }
            AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
            String userName = principal.getName();
            Map<String, Object> attributes = principal.getAttributes();
            UserEntity transfer = transfer(attributes);
        //查询是否有注册信息 或者 特权信息
            UserEntity userById = userService.findById(transfer.getId());
            if(userById == null ) {
                //注册
                transfer.setUserType(ConstantUtils.USER_TEACHER);
                transfer.setAction(ActionEnum.create.getCode());
                userService.save(transfer);
            }else if (StringUtils.isEmpty(userById.getUserName() )){
                //补全信息
                transfer.setAction(ActionEnum.update.getCode());
                transfer.setUserType(userById.getUserType());
                userService.save(transfer);
            }
        String sessionId = request.getSession().getId();
        UserEntity byId = userService.findById(transfer.getId());
        String secretKey=Commons.getSecretKey(byId.getId()+byId.getUserType());
        byId.setSecretKey(secretKey);
        byId.setJSESSIONID(sessionId);
        return Result.success(byId);

    }

    private UserEntity transfer( Map<String, Object> attributes) {
        UserEntity user = new UserEntity();
        String id = attributes.get("USERID")==null? "":(String) attributes.get("USERID");
        String userName = attributes.get("USERNAME")==null? "":(String) attributes.get("USERNAME");
        String trueName = attributes.get("TRUENAME")==null? "":(String) attributes.get("TRUENAME");
        String schoolName = attributes.get("SCHOOLNAME")==null? "":(String) attributes.get("SCHOOLNAME");
        String subject = attributes.get("SUBJECT")==null? "":(String) attributes.get("SUBJECT");
        user.setId(id);
        user.setUserName(userName);
        user.setTrueName(trueName);
        user.setSchoolName(schoolName);
        user.setSubject(subject);
        return user;
    }


    //登出自选回调网址
    @GetMapping(value = "/logout")
    public void logout(
            @RequestParam(value = "responseUrl", required = true) String responseUrl,
            HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "/https://sso.bjtzeduyun.com/");//设置跨域允许
        try {
            request.getSession().invalidate();
            response.sendRedirect(casconfigProperties.getLogoutUrl()+responseUrl);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @GetMapping(value = "/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "/https://sso.bjtzeduyun.com/");//设置跨域允许
       return "hello";
    }

    @RequestMapping(value = "/nohello")
    public String nohello(@RequestParam(value = "callback", required = true) String callback,HttpServletRequest request,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "/https://sso.bjtzeduyun.com/");//设置跨域允许
        String id = request.getSession().getId();
        try {
            logger.info(callback+"?JSESSIONID="+id);
            response.sendRedirect(callback+"?JSESSIONID="+id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "nohello";
    }

    @GetMapping(value = "selectSpecial")
    @ResponseBody
    public Result selectSpecial(UserEntity dto){
        if(!Commons.passCheck("1",dto.getSecretKey())){
            return Result.failed("请求安全校验无法通过");
        }
        PageBean<UserEntity> byPgList = userService.findSpecial(dto);
        return Result.success(byPgList);
    }

    @PostMapping(value = "createSpecial")
    @ResponseBody
    public Result createSpecial(UserEntity dto,HttpServletRequest request){
        if(!Commons.passCheck(dto.getId()+dto.getUserType().toString(),dto.getSecretKey())){
            return Result.failed("请求安全校验无法通过");
        }
        if (StringUtils.isEmpty(dto.getId()) ){
            return Result.build(ResultCode.PARAM_ERROR, "invalid argument");
        }
        UserEntity byId = userService.findById(dto.getId());
        if (byId == null){
            dto.setAction(ActionEnum.create.getCode());
        }else {
            dto.setAction(ActionEnum.update.getCode());
        }

        AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
        String userName = principal.getName();
        logger.info("***************************"+userName +" createSpecial :"+ dto.getId() +"="+dto.getUserType()+"***************************");
        return userService.save(dto);
    }



}
