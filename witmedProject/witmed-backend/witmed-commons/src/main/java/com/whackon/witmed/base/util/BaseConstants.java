package com.whackon.witmed.base.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Properties;

/**
 * <b>基础信息功能 - 基础常量类</b>
 *
 * @version 1.0.0
 * @Author 张武超
 * @Date 2022/1/6
 * @serial 1.0.0
 */
public class BaseConstants {
	private static Properties props = new Properties();
	//创建日志对象
	private static Logger logger = LoggerFactory.getLogger(BaseConstants.class);

	static {
		try {
			props.load(BaseConstants.class.getClassLoader().getResourceAsStream("props/base/base.properties"));
		} catch (Exception e) {
			System.out.println("加载常量类失败");
			e.printStackTrace();
			logger.error(e.getMessage() + ":" + new Date(), e);
		}
	}

	/**
	 * <b>加密秘钥信息</b>
	 */
	public static final String SECRET_KEY = props.getProperty("secret.key");
	/**
	 * <b>用户认证有效时长</b>
	 */
	public static final Long EXPIRE_AUTH_SEC = Long.parseLong(props.getProperty("expire.auth.sec"));

}