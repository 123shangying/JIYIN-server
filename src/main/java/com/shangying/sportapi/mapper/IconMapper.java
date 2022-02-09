package com.shangying.sportapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shangying.sportapi.pojo.Icon;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shangying
 * @since 2021-10-21
 */
@Mapper
@Repository
public interface IconMapper extends BaseMapper<Icon> {

}
