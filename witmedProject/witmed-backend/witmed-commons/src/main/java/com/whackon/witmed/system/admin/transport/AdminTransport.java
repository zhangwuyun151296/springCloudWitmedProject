package com.whackon.witmed.system.admin.transport;

import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <b>系统功能 - 系统用户传输层接口</b>
 *
 * @version 1.0.0
 * @Author 张武超
 * @Date 2022/1/6
 * @serial 1.0.0
 */
//添加远程调用
@FeignClient(name="witmed-system-provider")
public interface AdminTransport {
	/**
	 * 根据手机号码查询系统用户视图对象信息
	 * @param cellphone
	 * @return
	 */
	@PostMapping("/system/admin/admin/trans/cellphone")
	AdminVO getAdminVOByCellphone(@RequestParam String cellphone)throws Exception;
}
