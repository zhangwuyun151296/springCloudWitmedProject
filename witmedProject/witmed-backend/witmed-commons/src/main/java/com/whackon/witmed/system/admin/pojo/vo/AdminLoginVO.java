package com.whackon.witmed.system.admin.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * <b>系统功能 - 系统用户登录视图对象</b>
 *
 * @version 1.0.0
 * @Author 张武超
 * @Date 2022/1/6
 * @serial 1.0.0
 */
@Data
public class AdminLoginVO implements Serializable {
	private static final long serialVersionUID = -1399343105549132108L;
	@NotBlank(message = "未填写手机号码")
	@Pattern(regexp = "1[3456789]\\d{9}",message = "手机号码格式错误")
	private String cellphone;           //登录手机号码
	@NotBlank(message = "未填写登录密码")
	@Pattern(regexp = "[a-zA-Z0-9_@#]{6,}",message = "登录密码格式错误")
	private String password;            //登录密码
}
