package com.shangying.sportapi.mapper;

import com.shangying.sportapi.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  用户-Mapper 接口
 * </p>
 *
 * @author shangying
 * @since 2021-10-14
 * Repository // 代表持久层
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
