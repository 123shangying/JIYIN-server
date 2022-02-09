package com.shangying.sportapi.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shangying.sportapi.mapper.UserMapper;
import com.shangying.sportapi.pojo.User;
import com.shangying.sportapi.utils.MD5;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * <p>
 *  用户-前端控制器
 * </p>
 *
 * @author shangying
 * @since 2021-10-14
 */
@RestController
@RequestMapping("/sportapi/user")
public class UserController {
    /**
     * 继承了BaseMapper，所有的方法都来自己父类
     * 我们也可以编写自己的扩展方法！
     */
    private final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    MD5 md5=new MD5();

    /**
     *  用户登录
     * @param username 用户名
     * @param password 密码
     * @return 返回0表示失败,1表示成功selectCount
     */
    @PostMapping("/login")
    @ResponseBody
    private int userLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        //加密
        String md5pwd= md5.md5(password);
        // 查询名字狂神说
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        wrapper.eq("password",md5pwd);
        // 查询一个数据，出现多个结果使用List 或者 Map
        return userMapper.selectCount(wrapper);
    }


    /**
     *  注册接口
     * @param username 用户名
     * @param password 密码
     * @param qq 邮箱
     * @return 返回0表示注册失败  返回1表示注册成功
     */
    @PostMapping("/register")
    @ResponseBody
    private int userRegister(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("qq")  String qq) {
        //定义返回值
       int count =0;
        //        判断邮箱是否存在
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("qq", qq)
                .or()
                .eq("username", username);
        int c = userMapper.selectCount(wrapper);
        if (c == 0) {
//            插入用户数据
            User user = new User();
            //加密
            String md5pwd= md5.md5(password);
            // 通过条件自动拼接动态sql
            user.setUsername(username);
            user.setPassword(md5pwd);
            user.setQq(qq);
            user.setGmtCreate(new Date());
            user.setGmtModified(new Date());
            // 注意：updateById 但是参数是一个 对象！
            final double d = Math.random();
            final int i = (int)(d*71);

            count= userMapper.insert(user);
            IconController.image(user.getId(),String.valueOf(i));
        }
        return count;
    }


    /**
     * 显示用户信息
     * @param username 用户名
     * @return  用户信息JSON
     */
    @PostMapping("/show")
    @ResponseBody
   private User userShow(
           @RequestParam("username") String username){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        // 查询一个数据，出现多个结果使用List 或者 Map
        wrapper.select("id","username","qq","gmt_Create");
        return userMapper.selectOne(wrapper);
    }

    /**
     * 模糊查询，通过邮箱或者用户名获取用户名
     * @param name 邮箱
     * @return username   json
     */
    @PostMapping("/fname")
    @ResponseBody
     private User getUserNameQq(
             @RequestParam("name") String name) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("qq",name)
                .or()
                .eq("username",name);
        // 查询一个数据，出现多个结果使用List 或者 Map
        wrapper.select("username");
        return userMapper.selectOne(wrapper);
    }

    /**
     * 模糊查询，通过邮箱或者用户名获取用户名
     * @param id 邮箱
     * @return id   json
     */
    @PostMapping("/uname")
    @ResponseBody
    private User getName(
            @RequestParam("id") int id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        // 查询一个数据，出现多个结果使用List 或者 Map
        wrapper.select("username");
        return userMapper.selectOne(wrapper);
    }
    /**
     * 修改密码，只需要验证用户名，这个用户名一般自动获取但需要旧密码
     * @param username 用户名
     * @param oldpassword 旧密码
     * @param newpassword 新密码
     * @return 返回数据库更新结果.返回1，表示成功(或者密码相同)，0表示失败
     */
    @PostMapping("/updatepwd")
    @ResponseBody
    private int updateUserPassword(
            @RequestParam("username") String username,
            @RequestParam("oldpassword") String oldpassword,
            @RequestParam("newpassword") String newpassword) {
        //更新语句
        String newmd5pwd= md5.md5(newpassword);
        String oldmd5pwd= md5.md5(oldpassword);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        查询条件
        wrapper.eq("username",username)
                .eq("password",oldmd5pwd);
//        修改内容
        User user = new User();
        // 通过条件自动拼接动态sql
        user.setPassword(newmd5pwd);
        user.setGmtModified(new Date());
        return userMapper.update(user,wrapper);
    }

    /**
     * 忘记密码（修改密码）不需要旧密码
     * @param qq  邮箱
     * @param username   用户名
     * @param newpassword   新密码
     * @return 受影响的行数   返回1，表示成功(或者密码相同)，0表示失败
     */
    @PostMapping("/findpwd")
    @ResponseBody
    private int findPwd(
            @RequestParam("qq") String qq,
            @RequestParam("username") String username,
            @RequestParam("newpassword") String newpassword) {
        //更新语句
        String md5pwd= md5.md5(newpassword);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        查询条件
        wrapper.eq("username",username)
                .eq("qq",qq);
//        修改内容
        User user = new User();
        // 通过条件自动拼接动态sql
        user.setUsername(username);
        user.setPassword(md5pwd);
        user.setGmtModified(new Date());
        return userMapper.update(user,wrapper);
    }

    /**
     * 获取用户id
     * @param username 用户名
     * @return  json对象，包含用户名
     */
    @PostMapping("/getid")
    @ResponseBody
    private User getUserId(
            @RequestParam("username") String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        // 查询一个数据，出现多个结果使用List 或者 Map
        wrapper.select("id");
        return userMapper.selectOne(wrapper);
    }

}

