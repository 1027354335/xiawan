package com.xtoken.gradetoken.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xtoken.gradetoken.entity.TAdmin;
import com.xtoken.gradetoken.mapper.TAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: MyUserDetailsService
 * @Description: TODO
 * @version: v1.８.0
 * @author: LLLXH
 * @date: 2021/11/14 0:19
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private TAdminMapper adminMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //调用数据库
        TAdmin users = adminMapper.selectOne(new QueryWrapper<TAdmin>().eq("username", username));
        //判断
        if (null == users) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        return new User(users.getUsername(), new BCryptPasswordEncoder().encode(users.getPassword()), auths);
    }
}
