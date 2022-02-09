package com.shangying.sportapi.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shangying.sportapi.mapper.ImagesMapper;
import com.shangying.sportapi.pojo.Images;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialBlob;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  图片-前端控制器
 * </p>
 *
 * @author shangying
 * @since 2021-10-14
 */
@RestController
@RequestMapping("/sportapi/images")
public class ImagesController {
    private final ImagesMapper imagesMapper;
    private Connection hibernate;

    public ImagesController(ImagesMapper imagesMapper) {
        this.imagesMapper = imagesMapper;
    }

    /**
     * 插入图片数据
     * @param did  动态id
     * @param id   用户id
     * @param bitmap  图片二进制
     * @return  受影响的行数1成功0失败
     */
    @PostMapping("/insimags")
    @ResponseBody
    private int insImages(
            @RequestParam("did") int did,
            @RequestParam("id") int id,
            @RequestParam("bitmap") String bitmap
    ) throws UnsupportedEncodingException, SQLException {
        //            插入动态数据
        Images images = new Images();
        // 通过条件自动拼接动态sql
        images.setUId(id);
        images.setDId(did);
        Blob b = new SerialBlob(bitmap.getBytes("UTF-8"));
        images.setBitmap(b);
        System.out.println(b+"1111");
        images.setGmtCreate(new Date());
        images.setGmtModified(new Date());
        return imagesMapper.insert(images);
    }



    /**
     * 显示所有动态
     * @return  List所有用户动态
     */
    @PostMapping("/showimages")
    @ResponseBody
    private List<Images> showAllImages() {
        // 参数是一个 Wrapper ，条件构造器，这里我们先不用 null
        // 查询全部动态
        QueryWrapper<Images> wrapper = new QueryWrapper<>();
        wrapper.select("d_id","gmt_Modified","bitmap");
        return imagesMapper.selectList(wrapper);
    }
}

