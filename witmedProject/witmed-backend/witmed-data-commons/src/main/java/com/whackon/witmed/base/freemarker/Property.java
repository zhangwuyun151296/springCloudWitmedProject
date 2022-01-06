package com.whackon.witmed.base.freemarker;

import lombok.Data;

/**
 * <b>智慧医疗信息平台-</b>
 *
 * @version 1.0.0
 * @Author 张武超
 * @Date 2022/1/5
 * @serial 1.0.0
 */
@Data
public class Property {
	private String type;    //数据类型
	private String name;    //属性名
	private String comment;//注释
}
