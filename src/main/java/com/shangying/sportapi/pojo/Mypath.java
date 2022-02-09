package com.shangying.sportapi.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 轨迹-实体类
 * </p>
 *
 * @author shangying
 * @since 2021-10-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Mypath对象", description="")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Mypath implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "运动轨迹id")
    @TableId(value = "p_id", type = IdType.AUTO)
    private Integer pId;

    @ApiModelProperty(value = "用户id")
    private Integer uId;

    @ApiModelProperty(value = "运动轨迹")
    private String path;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @Version
    private Integer version;


}
