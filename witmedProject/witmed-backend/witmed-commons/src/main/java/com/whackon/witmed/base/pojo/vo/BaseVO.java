package com.whackon.witmed.base.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.security.PrivateKey;
import java.util.Date;

/**
 * <b>基础信息功能-基础视图信息</b>
 * <p>
 *     基础视图信息设置如下属性<br/>
 *     1、status：系统状态<br/>
 *     2、createdUser：创建人<br/>
 *     3、createTime：创建时间<br/>
 *     4、updateUser：修改人<br/>
 *     5、updateTime：修改时间<br/>
 *     本项目所有功能视图信息<b>都必须继承于本基础视图信息</b>
 * </p>
 *
 * @version 1.0.0
 * @Author 张武超
 * @Date 2021/12/29 23:30
 * @serial 1.0.0
 */
@Data
public class BaseVO implements Serializable {
	private static final long serialVersionUID = -8822520574694244749L;
	private String status;                  //系统状态：0-禁用，1-启用
	private String createdUser;             //创建人
	private Date createdTime;                //创建时间
	private String updateUser;              //修改人
	private Date updateTime;                //修改时间
}
