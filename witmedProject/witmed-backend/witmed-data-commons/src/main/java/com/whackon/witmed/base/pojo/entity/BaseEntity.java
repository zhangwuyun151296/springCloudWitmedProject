package com.whackon.witmed.base.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * <b>基础信息功能-基础实体信息</b>
 * <p>
 *     基础实体信息设置如下属性<br/>
 *     1、status：系统状态<br/>
 *     2、createdUser：创建人<br/>
 *     3、createTime：创建时间<br/>
 *     4、updateUser：修改人<br/>
 *     5、updateTime：修改时间<br/>
 *     本项目所有功能实体信息<b>都必须继承于本基础实体信息</b>
 * </p>
 *
 * @version 1.0.0
 * @Author 张武超
 * @Date 2021/12/29 23:30
 * @serial 1.0.0
 */
@Data
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = -581900270125913243L;
	@TableField(value = "status")
	private String status;                  //系统状态：0-禁用，1-启用
	@TableField(value = "createdUser")
	private String createdUser;             //创建人
	@TableField(value = "createdTime")
	private Date createdTime;                //创建时间
	@TableField(value = "updateUser")
	private String updateUser;              //修改人
	@TableField(value = "updateTime")
	private Date updateTime;                //修改时间


}
