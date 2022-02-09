package com.shangying.sportapi.controller;


import com.shangying.sportapi.mapper.MypathMapper;
import com.shangying.sportapi.pojo.Mypath;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <p>
 *  轨迹-前端控制器
 * </p>
 *
 * @author shangying
 * @since 2021-10-14
 */
@RestController
@RequestMapping("/sportapi/mypath")
public class MypathController {
    private final MypathMapper mypathMapper;

    public MypathController(MypathMapper mypathMapper) {
        this.mypathMapper = mypathMapper;
    }


    /**
     * 插入运动数据
     * @param id  用户id
     * @return  受影响的行数1成功0失败
     */
    @PostMapping("/inspath")
    @ResponseBody
    private int insPath(
            @RequestParam("id") Integer id,
            @RequestParam("path") String path
    ) {
        //            插入动态数据
        Mypath mypath = new Mypath();
        // 通过条件自动拼接动态sql
        mypath.setUId(id);
        mypath.setPath(path);
        mypath.setGmtCreate(new Date());
//        返回插入对象的id
        return mypathMapper.insert(mypath);
    }

}

