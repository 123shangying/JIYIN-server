package com.shangying.sportapi.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shangying.sportapi.mapper.EmailMapper;
import com.shangying.sportapi.pojo.Email;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  邮箱-前端控制器
 * </p>
 *
 * @author shangying
 * @since 2021-10-14
 */
@RestController
@RequestMapping("/sportapi/email")
public class EmailController {

    /**
     * 继承了BaseMapper，所有的方法都来自己父类
     * 我们也可以编写自己的扩展方法！
     */
    private final EmailMapper emailMapper;

    public EmailController(EmailMapper emailMapper) {
        this.emailMapper = emailMapper;
    }


    /**
     * 验证邮箱
     * @param qq 邮箱账号
     * @param code 验证码
     * @return 返回0表示失败,1表示成功selectCount
     */
    @PostMapping("/setemail")
    @ResponseBody
    public int setEmail(@RequestParam("qq") String qq, @RequestParam("code") String code) {
        QueryWrapper<Email> wrapper = new QueryWrapper<>();
        wrapper.eq("qq",qq);
        wrapper.eq("code",code);
        // 查询一个数据，出现多个结果使用List 或者 Map
        return emailMapper.selectCount(wrapper);
    }
}

