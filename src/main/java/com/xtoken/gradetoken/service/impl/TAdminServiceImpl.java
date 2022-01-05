package com.xtoken.gradetoken.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xtoken.gradetoken.config.security.JwtTokenUtils;
import com.xtoken.gradetoken.entity.RespBean;
import com.xtoken.gradetoken.entity.TAdmin;
import com.xtoken.gradetoken.mapper.TAdminMapper;
import com.xtoken.gradetoken.service.MyUserDetailsService;
import com.xtoken.gradetoken.service.TAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
* @author luzong
* @description 针对表【t_admin】的数据库操作Service实现
* @createDate 2021-11-14 01:24:46
*/
@Service
public class TAdminServiceImpl extends ServiceImpl<TAdminMapper, TAdmin>
implements TAdminService {
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private TAdminMapper adminMapper;
    /**
     * 登录成功后返回token
     * @param username
     * @param password
     * @param request
     * @return
     */
    @Override
    public RespBean login(String username, String password, String code, HttpServletRequest request) {
        // 登录
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (null == userDetails || !passwordEncoder.matches(password, userDetails.getPassword())) {
            return RespBean.error("用户名或密码错误");
        }
        if (!userDetails.isEnabled()) {
            return RespBean.error("账号被禁用，请联系管理员!");
        }
        // 更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // 获取token
        String token = jwtTokenUtils.generateToken(userDetails);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("tokenHead", tokenHead);
        return RespBean.success("登录成功", map);
    }

    @Override
    public String getTest() {
        return "lallalalalla";
    }
}
