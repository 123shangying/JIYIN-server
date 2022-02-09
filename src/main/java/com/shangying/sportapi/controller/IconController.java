package com.shangying.sportapi.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shangying.sportapi.mapper.IconMapper;
import com.shangying.sportapi.pojo.Icon;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shangying
 * @since 2021-10-21
 */
@RestController
@RequestMapping("/sportapi/icon")
public class IconController {


    private static BaseMapper<Icon> iconMapper;


    public IconController(IconMapper iconMapper) {
        IconController.iconMapper = iconMapper;
    }


    public static int image(int a, String b){
        Icon icon = new Icon();
        // 通过条件自动拼接动态sql
        icon.setUId(a);
        icon.setImage(b);
        System.out.println(b);
        icon.setGmtCreate(new Date());
        icon.setGmtModified(new Date());
//        返回插入对象的id
        return iconMapper.insert(icon);
    }



    /**
     * 显示对应评论
     * @return  List所有用户动态
     */
    @PostMapping("/showicon")
    @ResponseBody
    private List<Icon> showAll(
            @RequestParam("uid") Integer did) {
        // 参数是一个 Wrapper ，条件构造器，这里我们先不用 null
        // 显示对应评论
        QueryWrapper<Icon> wrapper = new QueryWrapper<>();
        wrapper.eq("u_id",did);
        wrapper.select("image");
        return iconMapper.selectList(wrapper);
    }
}

