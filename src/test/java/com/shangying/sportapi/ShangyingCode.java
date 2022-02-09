package com.shangying.sportapi;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;


/**
 * Created with IntelliJ IDEA.
 * User: shangying.
 * Date: 2021/10/14.
 * Time: 20:14.
 * Explain:代码自动生成的配置
 */
public class ShangyingCode {
    public static void main(String[] args) {
    // 需要构建一个 代码自动生成器 对象
        AutoGenerator mpg = new AutoGenerator();
    // 配置策略
    // 1、全局配置
        GlobalConfig gc = new GlobalConfig();
        //文件地址
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src/main/java");
        //作者
        gc.setAuthor("shangying");
        gc.setOpen(false);
        // 是否覆盖
        gc.setFileOverride(false);
        // 去Service的I前缀
        gc.setServiceName("%sService");
        gc.setIdType(IdType.AUTO);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);
//2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://shangying.xyz:3306/sport?" +
                "useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("611@Foxmail.com");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
//3、包的配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("sportapi");
        pc.setParent("com.shangying");
        //实体类
        pc.setEntity("pojo");
        //层
        pc.setMapper("mapper");
        //层
        pc.setService("service");
        //层
        pc.setController("controller");
        mpg.setPackageInfo(pc);
//4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        //表名
        // 设置要映射的表名
        strategy.setInclude("icon");
                strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自动lombok；
        strategy.setEntityLombokModel(true);
        //逻辑删除字段
        strategy.setLogicDeleteFieldName("is_deleted");
// 自动填充配置
        // 创建时间
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        //更新时间
        TableFill gmtModified = new TableFill("gmt_modified",
                FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);
// 乐观锁
        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
        //localhost:8081/sport_1_1
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        //执行
        mpg.execute();

    }

}
