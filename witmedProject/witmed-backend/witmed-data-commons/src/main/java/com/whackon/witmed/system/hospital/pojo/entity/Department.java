package com.whackon.witmed.system.hospital.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>系统功能 - 医院部门实体信息</b>
 * <p>
 *     医院部门实体信息设置如下属性<br/>
 *     1、id：主键<br/>
 *     2、hospital：所在医院<br/>
 *     3、parent：上级部门<br/>
 *     4、code：部门编码<br/>
 *     5、name：部门名称<br/>
 * </p>
 * @author 张武超
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@TableName(value = "sys_department")
public class Department extends BaseEntity {
	private static final long serialVersionUID = -2622948860025868982L;
	@TableId(value = "id",type = IdType.AUTO)
	private Long id;                    //主键
	@TableField(value = "hospital")
	private String hospital;            //所在医院
	@TableField(value = "parent")
	private String parent;              //上级部门
	@TableField(value = "code")
	private String code;                //部门编码
	@TableField(value = "name")
	private String name;                //部门名称

}
