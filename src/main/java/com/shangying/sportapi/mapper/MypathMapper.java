package com.shangying.sportapi.mapper;

import com.shangying.sportapi.pojo.Mypath;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  轨迹-Mapper 接口
 * </p>
 *
 * @author shangying
 * @since 2021-10-14
 */
@Mapper
@Repository
public interface MypathMapper extends BaseMapper<Mypath> {

}
