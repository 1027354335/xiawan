package com.xtoken.gradetoken.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xtoken.gradetoken.entity.TAdminRole;
import com.xtoken.gradetoken.mapper.TAdminRoleMapper;
import com.xtoken.gradetoken.service.TAdminRoleService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
* @author luzong
* @description 针对表【t_admin_role】的数据库操作Service实现
* @createDate 2021-11-14 01:26:03
*/
@Service
public class TAdminRoleServiceImpl extends ServiceImpl<TAdminRoleMapper, TAdminRole>
implements TAdminRoleService {

}
