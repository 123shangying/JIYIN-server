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
 * 动态-实体类
 * </p>
 *
 * @author shangying
 * @since 2021-10-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Dynamic对象", description="")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dynamic implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "动态id")
    @TableId(value = "d_id", type = IdType.AUTO)
    private Integer dId;

    @ApiModelProperty(value = "用户id")
    private Integer uId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = " 内容")
    private String content;

    @ApiModelProperty(value = "隐私权限")
    private String privacy;

    @TableLogic
    private Boolean isDeleted;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @Version
    private Integer version;


}
