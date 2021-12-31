package com.whackon.witmed.base.pojo.enums;

/**
 * <b>基础信息功能-系统状态枚举信息</b>
 * <p>
 *     基础视图信息设置如下属性
 *     1、code：状态编码<br/>
 *     2、remarks：状态说明<br/>
 *        STATUS_ENABLE：1-启用
 *        STATUS_DISABLE：0-禁用
 * </p>
 *
 * @Author 张武超
 * @Date 2021/12/29 23:30
 * @serial 1.0.0
 * @version 1.0.0
 */
public enum StatusCode {
	STATUS_ENABLE("1","启用"),
	STATUS_DISABLE("0","禁用");
	private String code;                        //状态编码
	private String remarks;                     //状态说明

	private StatusCode(String code, String remarks) {
		this.code = code;
		this.remarks = remarks;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
