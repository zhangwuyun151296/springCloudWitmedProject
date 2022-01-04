package com.whackon.witmed.base.pojo.enums;

/**
 * <b>基础信息功能-系统响应编码枚举信息</b>
 * <p>
 *     系统响应编码枚举信息设置如下属性<br/>
 *     1、code：响应编码<br/>
 *     2、remarks：编码说明<br/>
 *        RESPONSE_SUCCESS：20000-系统业务处理完毕，响应成功<br/>
 *        RESPONSE_UNAUTH：30000-系统用户未进行认证<br/>
 *        RESPONSE_ERROR：40000-系统业务处理错误<br/>
 *        RESPONSE_EXCEPTION：50000-系统响异常<br/>
 * </p>
 *
 * @Author 张武超
 * @Date 2021/12/29 23:30
 * @serial 1.0.0
 * @version 1.0.0
 */
public enum ResponseCode {
	RESPONSE_SUCCESS("20000","系统业务处理完毕，响应成功"),
	RESPONSE_UNAUTH("30000","系统用户未进行认证"),
	RESPONSE_ERROR("40000","系统业务处理错误"),
	RESPONSE_EXCEPTION("50000","系统响异常");
	private String code;                        //响应编码
	private String remarks;                     //编码说明

	private ResponseCode(String code, String remarks) {
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
