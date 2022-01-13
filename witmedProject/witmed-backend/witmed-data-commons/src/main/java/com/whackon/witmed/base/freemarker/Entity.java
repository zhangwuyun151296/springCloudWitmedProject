package com.whackon.witmed.base.freemarker;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <b>智慧医疗信息平台-</b>
 *
 * @version 1.0.0
 * @Author 张武超
 * @Date 2022/1/5
 * @serial 1.0.0
 */
@Data
public class Entity implements Serializable {
	private static final long serialVersionUID = 7666766629557858823L;
	private String packageName;             //实体类对应包名
	private String className;               //实体类对应类名
	private List<Property> propertyList;    //实体类对应属性名

	public Entity(String packageName, String className, List<Property> propertyList) {
		this.packageName = packageName;
		this.className = className;
		this.propertyList = propertyList;
	}
}