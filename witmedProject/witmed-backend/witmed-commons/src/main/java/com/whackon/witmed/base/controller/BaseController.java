package com.whackon.witmed.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <b>基础信息功能 - 基础控制层类</b>
 *  <p>基础控制层依赖注册了如下属性：<br/>
 *      1、HttpServletRequest<br/>
 *      2、HttpServletResponse<br/>
 *      3、HttpSession<br/>
 *      本项目所有功能控制层类?<b>都必须继承于本基础控制层类</b>
 *  </p>
 * @Author 张武超
 * @Date 2021/12/29 23:30
 * @serial 1.0.0
 * @version 1.0.0
 */
@Controller("baseController")
public class BaseController {

	@Autowired//根据类型注入HttpServletRequest
	 protected HttpServletRequest request;
	@Autowired//根据类型注入HttpServletResponse
	 protected HttpServletResponse response;
	 @Autowired//根据类型注入HttpSession
	 protected HttpSession session;

}
