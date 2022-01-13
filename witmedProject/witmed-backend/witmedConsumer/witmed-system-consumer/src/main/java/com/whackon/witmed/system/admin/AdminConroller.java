package com.whackon.witmed.system.admin;

import cn.hutool.crypto.digest.MD5;
import com.whackon.witmed.base.controller.BaseController;
import com.whackon.witmed.base.pojo.enums.StatusCode;
import com.whackon.witmed.base.pojo.vo.ResponseVO;
import com.whackon.witmed.base.util.BaseConstants;
import com.whackon.witmed.base.util.RedisUtil;
import com.whackon.witmed.base.util.TokenUtil;
import com.whackon.witmed.system.admin.pojo.vo.AdminLoginVO;
import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import com.whackon.witmed.system.admin.transport.AdminTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>系统功能 - 系统用户控制层</b>
 *
 * @version 1.0.0
 * @Author 张武超
 * @Date 2022/1/6
 * @serial 1.0.0
 */
@RestController("adminConroller")
@RequestMapping("/system/admin/admin")
public class AdminConroller extends BaseController {

	@Autowired
	private AdminTransport adminTransport;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * <b>用户使用登录视图进行登录操作</b>
	 * @param adminLoginVO
	 * @param result 错误信息
	 * @return
	 */
	@PostMapping("/login")
	public ResponseVO adminLogin(@RequestBody@Validated AdminLoginVO adminLoginVO, BindingResult result)throws Exception{
		//判断错误信息对象BindingResult中是否包含有错误信息
		if (result.hasErrors()){
			return ResponseVO.error("请填写正确的手机号码和登录密码");
		}
		//用户信息校验成功，根据手机号查询用户信息
		AdminVO adminVO=adminTransport.getAdminVOByCellphone(adminLoginVO.getCellphone());
		//判断所得到的用户信息是否存在
		if (adminVO==null){
			return ResponseVO.error("手机号码或者登录密码错误");
		}
		//所得到的用户信息已存在，判断用户系统状态是否为启用
		if (StatusCode.STATUS_DISABLE.equals(adminVO.getStatus())){
			return ResponseVO.error("该用户禁用登录");
		}
		//该用户处于启用状态，则对密码进行加密，并且判断密码是否相同
		if (!adminVO.getPassword().equals(MD5.create().digestHex(adminLoginVO.getPassword()))) {
			return ResponseVO.error("手机号码或者登录密码错误");
		}
		//此时用户的登录密码正确，那么此时该用户登录成功，使用工具类生成系统唯一的令牌（token）
		//设置有效载荷
		Map<String,String> claimmMap=new HashMap<String,String>();
		claimmMap.put("id",adminVO.getId());
		String token= TokenUtil.createToken(claimmMap, BaseConstants.EXPIRE_AUTH_SEC);
		//将该token作为key用户信息作为value存储在Redis中，并设置有效期为30分钟
		if (redisUtil.saveToRedis(token,adminVO,BaseConstants.EXPIRE_AUTH_SEC)){
			//此时将信息存储在Redis中成功，那么将token返回给客户
			//此时为了将token交给客户进行存储，那么我们可以选择将Token绑定到Http响应对象的消息头的部分Authorization
			response.setHeader("Authorization",token);
			//返回前端登录成功结果
			return ResponseVO.success("系统用户登录成功",adminVO);
		}
		return ResponseVO.error("登录失败");
	}


}
