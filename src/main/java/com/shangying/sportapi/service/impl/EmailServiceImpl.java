package com.shangying.sportapi.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shangying.sportapi.mapper.EmailMapper;
import com.shangying.sportapi.pojo.Email;
import com.shangying.sportapi.service.EmailService;
import org.springframework.stereotype.Service;


/**
 * <p>
 *  邮箱-服务实现类
 * </p>
 *
 * @author shangying
 * @since 2021-10-14
 */
@Service
public class EmailServiceImpl extends ServiceImpl<EmailMapper, Email> implements EmailService {

}
