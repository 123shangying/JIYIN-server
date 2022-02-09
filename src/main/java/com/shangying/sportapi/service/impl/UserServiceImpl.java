package com.shangying.sportapi.service.impl;

import com.shangying.sportapi.pojo.User;
import com.shangying.sportapi.mapper.UserMapper;
import com.shangying.sportapi.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  用户-服务实现类
 * </p>
 *
 * @author shangying
 * @since 2021-10-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
