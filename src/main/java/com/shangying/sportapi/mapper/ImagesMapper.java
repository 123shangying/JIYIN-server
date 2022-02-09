package com.shangying.sportapi.mapper;

import com.shangying.sportapi.pojo.Images;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  图片-Mapper 接口
 * </p>
 *
 * @author shangying
 * @since 2021-10-14
 */
@Mapper
@Repository
public interface ImagesMapper extends BaseMapper<Images> {

}
