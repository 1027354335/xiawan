package com.xtoken.gradetoken.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xtoken.gradetoken.entity.RespBean;
import com.xtoken.gradetoken.entity.TAdmin;

import javax.servlet.http.HttpServletRequest;

/**
* @author luzong
* @description 针对表【t_admin】的数据库操作Service
* @createDate 2021-11-14 01:24:46
*/
public interface TAdminService extends IService<TAdmin> {
    RespBean login(String username, String password, String code, HttpServletRequest request);

    String getTest();
}
