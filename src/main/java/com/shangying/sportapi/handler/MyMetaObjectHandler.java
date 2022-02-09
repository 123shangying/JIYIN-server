package com.shangying.sportapi.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * // 一定不要忘记把处理器加到IOC容器中！
 * @author shangying
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {


    /**
     *   插入时的填充策略
     * @param metaObject  填充数据
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill.....");
        // setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject
        this.setFieldValByName("gmt_create",new Date(),metaObject);
        this.setFieldValByName("gmt_modified",new Date(),metaObject);
    }

    /**
     *   更新时的填充策略
     * @param metaObject  填充数据
     */

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill.....");
        this.setFieldValByName("gmt_modified",new Date(),metaObject);
    }
}
