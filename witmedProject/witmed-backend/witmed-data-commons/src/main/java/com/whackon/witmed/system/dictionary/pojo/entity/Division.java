package com.whackon.witmed.system.dictionary.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>系统功能 - 行政区划实体信息</b>
 * <p>
 *     行政区划实体信息设置如下属性<br/>
 *     1、id：主键<br/>
 *     2、parent：上级数据<br/>
 *     3、code：编码<br/>
 *     4、name：名称<br/>
 * </p>
 * @author 张武超
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@TableName(value = "sys_division")
public class Division extends BaseEntity {
	private static final long serialVersionUID = 7017774058889852096L;
	@TableId(value = "id",type = IdType.AUTO)
	private Long id;                    //主键
	@TableField(value = "parent")
	private String parent;              //上级区划
	@TableField(value = "code")
	private String code;                //编码
	@TableField(value = "name")
	private String name;                //名称
}
