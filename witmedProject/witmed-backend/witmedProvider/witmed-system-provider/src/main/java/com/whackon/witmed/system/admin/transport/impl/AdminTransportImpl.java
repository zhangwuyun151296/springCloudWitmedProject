package com.whackon.witmed.system.admin.transport.impl;

import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import com.whackon.witmed.system.admin.service.AdminService;
import com.whackon.witmed.system.admin.transport.AdminTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>系统功能 - 系统用户传输层接口实现类</b>
 *
 * @version 1.0.0
 * @Author 张武超
 * @Date 2022/1/6
 * @serial 1.0.0
 */
@RestController("adminTransport")
@RequestMapping("/system/admin/admin/trans")
public class AdminTransportImpl implements AdminTransport {

	@Autowired
	private AdminService adminService;

	/**
	 * 根据手机号码查询系统用户视图对象信息
	 * @param cellphone
	 * @return
	 */
	@Override
	@RequestMapping("/cellphone")
	public AdminVO getAdminVOByCellphone(String cellphone)throws Exception{
		return adminService.getAddminVOByCellphone(cellphone);
	}
}
