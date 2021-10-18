package com.combanc.cas.client.springboot.controller;

import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.entity.RoleAuthEntity;
import com.combanc.cas.client.springboot.service.RoleAuthService;
import com.combanc.cas.client.springboot.utils.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(path = {"/auth", "/applets/auth"})
public class RoleAuthController {
    @Autowired
    private RoleAuthService roleAuthService;

    @ResponseBody
    @PostMapping("/verify")
    Result getAuth(@RequestParam(value ="userId") String userId,
                   @RequestParam(value = "secretKey")String secretKey){
        if(!Commons.passCheck(userId,secretKey)){
            return Result.failed("请求安全校验无法通过");
        }
        RoleAuthEntity byId = roleAuthService.findById(userId);
        String generateKey = Commons.getSecretKey(byId.getRoleId().toString());
        byId.setSecretKey(generateKey);
        return Result.success(byId);
    }

}
