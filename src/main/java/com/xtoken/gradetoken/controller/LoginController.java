package com.xtoken.gradetoken.controller;

import com.xtoken.gradetoken.entity.AdminLoginParam;
import com.xtoken.gradetoken.entity.RespBean;
import com.xtoken.gradetoken.service.TAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @date:2021/9/10 8:26
 * @author:
 */
@Api(tags = "LoginController")
@RestController
public class LoginController {
    @Autowired
    private TAdminService adminService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request) {
        return adminService.login(adminLoginParam.getUsername(), adminLoginParam.getPassword(), adminLoginParam.getCode(), request);
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespBean logout() {
        return RespBean.success("注销成功");
    }

    @ApiOperation(value="测试一个接口")
    @GetMapping("/one")
    public @ResponseBody String GetTest(String key,String value){
        String q=adminService.getTest();
        return q;
    }

}
