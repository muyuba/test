package com.lixun.bookman.service.impl;

import com.lixun.bookman.entity.User;
import com.lixun.bookman.mapper.UserMapper;
import com.lixun.bookman.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lixun
 * @since 2021-04-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
