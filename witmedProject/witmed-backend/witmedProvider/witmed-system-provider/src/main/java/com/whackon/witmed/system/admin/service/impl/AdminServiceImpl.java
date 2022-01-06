package com.whackon.witmed.system.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whackon.witmed.base.util.PojoMapper;
import com.whackon.witmed.system.admin.dao.AdminDao;
import com.whackon.witmed.system.admin.pojo.entity.Admin;
import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import com.whackon.witmed.system.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b>系统功能 - 系统用户业务层接口实现类</b>
 *
 * @version 1.0.0
 * @Author 张武超
 * @Date 2022/1/6
 * @serial 1.0.0
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	/**
	 * 根据手机号码查询系统用户视图对象信息
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	@Override
	public AdminVO getAddminVOByCellphone(String cellphone) throws Exception {
		//创建 mybatis plus 查询对象 queryWrapper
		QueryWrapper<Admin> queryWrapper=new QueryWrapper<Admin>();
		//封装查询条件
		queryWrapper.eq("cellphone", cellphone);
		//进行查询
		Admin admin=adminDao.selectOne(queryWrapper);
		if (admin!=null){
			//将实体对象转换为视图对象,并进行返回
			AdminVO adminVO= PojoMapper.INSTANCE.paresToAdminVO(admin);
			return adminVO;
		}
		return null;
	}
}
