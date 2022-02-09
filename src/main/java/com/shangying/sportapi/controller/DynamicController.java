package com.shangying.sportapi.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shangying.sportapi.mapper.DynamicMapper;
import com.shangying.sportapi.pojo.Dynamic;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  动态-前端控制器
 * </p>
 *
 * @author shangying
 * @since 2021-10-14
 */
@RestController
@RequestMapping("/sportapi/dynamic")
public class DynamicController {
    private final DynamicMapper dynamicMapper;

    public DynamicController(DynamicMapper dynamicMapper) {
        this.dynamicMapper = dynamicMapper;
    }

    /**
     * 插入动态数据
     * @param id  用户id
     * @param title  标题
     * @param content 内容
     * @param privacy 隐私权限
     * @return  受影响的行数1成功0失败
     */
    @PostMapping("/insdata")
    @ResponseBody
    private int insData(
            @RequestParam("id") Integer id,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("privacy") String privacy
            ) {
        //            插入动态数据
        Dynamic dynamic = new Dynamic();
        // 通过条件自动拼接动态sql
        dynamic.setUId(id);
        dynamic.setTitle(title);
        dynamic.setContent(content);
        dynamic.setPrivacy(privacy);
        dynamic.setGmtCreate(new Date());
        dynamic.setGmtModified(new Date());

//        返回插入对象的id
        return dynamicMapper.insert(dynamic);
    }

    /**
     * 显示所有动态
     * @return  List所有用户动态
     */
    @PostMapping("/showall")
    @ResponseBody
    private List<Dynamic> showAll() {
        // 参数是一个 Wrapper ，条件构造器，这里我们先不用 null
        // 查询全部动态
        QueryWrapper<Dynamic> wrapper = new QueryWrapper<>();
        wrapper.eq("privacy","公开");
        wrapper.select("title","content","privacy","gmt_Modified","u_id","d_id");
        return dynamicMapper.selectList(wrapper);
    }

    /**
     * 查看公开数据个数
     * @return   个数selectCount
     */
    @PostMapping("/connpublic")
    @ResponseBody
    private int connpublic(){
        QueryWrapper<Dynamic> wrapper = new QueryWrapper<>();
        wrapper.eq("privacy","公开");
        // 查询一个数据，出现多个结果使用List 或者 Map
        return dynamicMapper.selectCount(wrapper);
    }

    /**
     *
     * @param id   动态id
     * @return  动态信息
     */
    @PostMapping("/showone")
    @ResponseBody
    private List<Dynamic> showOne(@RequestParam("id") Integer id) {
        // 参数是一个 Wrapper ，条件构造器，这里我们先不用 null
        QueryWrapper<Dynamic> wrapper = new QueryWrapper<>();
        wrapper.eq("d_id",id);
        wrapper.select("title","content","gmt_Modified","u_id","d_id");
        return dynamicMapper.selectList(wrapper);
    }
}

