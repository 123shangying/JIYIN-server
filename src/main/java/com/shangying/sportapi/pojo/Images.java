package com.shangying.sportapi.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/**
 * <p>
 * 图片-实体类
 * </p>
 *
 * @author shangying
 * @since 2021-10-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Images对象", description="")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Images implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图片id")
    @TableId(value = "i_id", type = IdType.AUTO)
    private Integer iId;

    @ApiModelProperty(value = "动态id（如果该图片是头像，则置为-1）")
    private Integer dId;

    @ApiModelProperty(value = "用户头像id（如果该图片是动态中的图片，则置为-1）")
    private Integer uId;

    @ApiModelProperty(value = "  bitmap图片对应的2进制")
    private Blob bitmap;

    @TableLogic
    private Boolean isDeleted;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @Version
    private Integer version;


}
