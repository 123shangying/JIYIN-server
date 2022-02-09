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
 * 评论-实体类
 * </p>
 *
 * @author shangying
 * @since 2021-10-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Comment对象", description="")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论id")
    @TableId(value = "c_id", type = IdType.AUTO)
    private Integer cId;

    @ApiModelProperty(value = "发表评论的用户id")
    private Integer uId;

    @ApiModelProperty(value = "评论对应的动态id")
    private Integer dId;

    @ApiModelProperty(value = "评论的父id，没有则为-1")
    private Integer fId;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @TableLogic
    private Boolean isDeleted;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @Version
    private Integer version;


}
