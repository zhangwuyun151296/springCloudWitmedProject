package com.whackon.witmed.system.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>系统功能 - 系统用户实体信息</b>
 *   <p>
 *  系统用户实体信息设置如下属性<br/>
 *  1、id：主键<br/>
 *  2、no：工号<br/>
 *  3、name：姓名<br/>
 *  4、cellphone：手机号码<br/>
 *  5、password：登录密码<br/>
 *  6、role：角色<br/>
 *  7、identity：身份<br/>
 *  8、department：所在部门<br/>
 *  9、techPos：服务者专业技术职务<br/>
 *  10、education：学历<br/>
 *  11、techPosRank：服务者专业技术职务等级<br/>
 * </p>
 * @author 张武超
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@TableName(value = "sys_admin")
public class Admin extends BaseEntity {
	private static final long serialVersionUID = -1159104965028559922L;
	@TableId(value = "id")
	private String id;                           //主键
	@TableField(value = "no")
	private String no;                           //工号
	@TableField(value = "name")
	private String name;                         //姓名
	@TableField(value = "cellphone")
	private String cellphone;                    //手机号码
	@TableField(value = "password")
	private String password;                     //登录密码
	@TableField(value = "role")
	private String role;                         //角色
	@TableField(value = "identity")
	private String identity;                     //身份
	@TableField(value = "department")
	private String department;                   //所在部门
	@TableField(value = "techPos")
	private String techPos;                      //服务者专业技术职务
	@TableField(value = "education")
	private String education;                    //学历
	@TableField(value = "techPosRank")
	private String techPosRank;                  //服务者专业技术职务等级

}
