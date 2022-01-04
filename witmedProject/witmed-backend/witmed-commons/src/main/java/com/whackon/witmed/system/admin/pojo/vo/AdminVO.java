package com.whackon.witmed.system.admin.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>系统功能 - 系统用户视图信息</b>
 * <p>
 *      系统用户视图信息设置如下属性<br/>
 *      1、id：主键<br/>
 *      2、no：工号<br/>
 *      3、name：姓名<br/>
 *      4、cellphone：手机号码<br/>
 *      5、password：登录密码<br/>
 *      6、role：角色<br/>
 *      7、identity：身份<br/>
 *      8、department：所在部门<br/>
 *      9、techPos：服务者专业技术职务<br/>
 *      10、education：学历<br/>
 *      11、techPosRank：服务者专业技术职务等级<br/>
 * </p>
 * @author 张武超
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class AdminVO extends BaseVO {
	private static final long serialVersionUID = -3261924255890475927L;
	private String id;                           //主键
	private String no;                           //工号
	private String name;                         //姓名
	private String cellphone;                    //手机号码
	private String password;                     //登录密码
	private String role;                         //角色
	private String identity;                     //身份
	private String department;                   //所在部门
	private String techPos;                      //服务者专业技术职务
	private String education;                    //学历
	private String techPosRank;                  //服务者专业技术职务等级
}
