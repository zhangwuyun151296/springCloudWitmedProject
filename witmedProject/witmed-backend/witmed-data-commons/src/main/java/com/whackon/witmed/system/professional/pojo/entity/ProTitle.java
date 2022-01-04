package com.whackon.witmed.system.professional.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>系统功能 - 专业职务实体信息</b>
 * <p>
 *     专业职务等级实体信息设置如下属性<br/>
 *     1、id：主键<br/>
 *     2、category：所属类别<br/>
 *     3、rank：所属等级<br/>
 *     4、code：编码<br/>
 *     5、name：名称<br/>
 * </p>
 * @author 张武超
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@TableName(value = "sys_pro_title")
public class ProTitle extends BaseEntity {
	private static final long serialVersionUID = 1529548575165272509L;
	@TableId(value = "id",type = IdType.AUTO)
	private Long id;                    //主键
	@TableField(value = "category")
	private String category;            //所属类别
	@TableField(value = "rank")
	private String rank;                //所属等级
	@TableField(value = "code")
	private String code;                //编码
	@TableField(value = "name")
	private String name;                //名称
}
