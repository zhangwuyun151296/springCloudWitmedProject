package com.whackon.witmed.system.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>系统功能 - 系统菜单功能实体信息</b>
 *<p>
 *     系统菜单功能实体信息设置如下属性<br/>
 *     1、id：主键<br/>
 *     2、code：主键<br/>
 *     3、parent：主键<br/>
 *     4、text：主键<br/>
 *     5、url：主键<br/>
 *     6、icon：主键<br/>
 *     7、sort：主键<br/>
 *</p>
 * @author 张武超
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@TableName(value = "sys_menu")
public class Menu extends BaseEntity {
	private static final long serialVersionUID = 8969977486776636748L;
	@TableId(value = "id",type = IdType.AUTO)
	private Long id;                    //主键
	@TableField(value = "code")
	private String code;                //角色编码
	@TableField(value = "parent")
	private String parent;              //上级菜单
	@TableField(value = "text")
	private String text;                //菜单文本
	@TableField(value = "url")
	private String url;                 //链接地址
	@TableField(value = "icon")
	private String icon;                //菜单图标样式
	@TableField(value = "sort")
	private Long sort;                  //排序

}
