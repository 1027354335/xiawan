package com.xtoken.gradetoken.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xtoken.gradetoken.entity.TMenu;
import com.xtoken.gradetoken.service.TMenuService;
import com.xtoken.gradetoken.mapper.TMenuMapper;
import org.springframework.stereotype.Service;

/**
* @author luzong
* @description 针对表【t_menu】的数据库操作Service实现
* @createDate 2021-11-14 01:34:32
*/
@Service
public class TMenuServiceImpl extends ServiceImpl<TMenuMapper, TMenu>
implements TMenuService{

}
