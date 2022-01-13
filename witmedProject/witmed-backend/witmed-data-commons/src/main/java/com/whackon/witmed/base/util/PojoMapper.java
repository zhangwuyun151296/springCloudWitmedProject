package com.whackon.witmed.base.util;

import com.whackon.witmed.system.admin.pojo.entity.Admin;
import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <b>实体与视图转换工具类</b>
 *
 * @version 1.0.0
 * @Author 张武超
 * @Date 2022/1/6
 * @serial 1.0.0
 */
@Mapper(componentModel = "spring")
public interface PojoMapper {
	PojoMapper INSTANCE= Mappers.getMapper(PojoMapper.class);

	/**
	 * 将实体转换成视图对象
	 * @param entity
	 * @return
	 */

	AdminVO paresToAdminVO(Admin entity);
	/**
	 * 将视图转换成实体对象
	 * @param adminVO
	 * @return
	 */
	Admin paresToAdminEntity(AdminVO adminVO);
}
