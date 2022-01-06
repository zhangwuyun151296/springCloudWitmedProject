package com.whackon.witmed.system.admin.service;

import com.whackon.witmed.system.admin.pojo.vo.AdminVO;

/**
 * <b>系统功能 - 系统用户业务层接口</b>
 *
 * @Author 张武超
 * @Date 2022/1/6
 * @version 1.0.0
 * @serial 1.0.0
 */
public interface AdminService {

	/**
	 *根据手机号码查询系统用户视图对象信息
	 * @param cellphone
	 * @return
	 */
	AdminVO getAddminVOByCellphone(String cellphone) throws Exception;
}
