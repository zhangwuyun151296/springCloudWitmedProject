package com.whackon.witmed.system.admin.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import com.whackon.witmed.system.dictionary.pojo.vo.EducationVO;
import com.whackon.witmed.system.dictionary.pojo.vo.IdentityVO;
import com.whackon.witmed.system.hospital.pojo.vo.DepartmentVO;
import com.whackon.witmed.system.professional.pojo.vo.ProCategoryVO;
import com.whackon.witmed.system.professional.pojo.vo.ProRankVO;
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
 *      6、roleVO：角色信息<br/>
 *      7、identityVO：身份信息<br/>
 *      8、departmentVO：所在部门信息<br/>
 *      9、proCategoryVO：服务者专业技术职务信息<br/>
 *      10、educationVO：学历信息<br/>
 *      11、proRankVO：服务者专业技术职务等级信息<br/>
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
	private RoleVO roleVO;                       //角色信息
	private IdentityVO identityVO;               //身份信息
	private DepartmentVO departmentVO;           //所在部门信息
	private ProCategoryVO proCategoryVO;         //服务者专业技术职务信息
	private EducationVO educationVO;             //学历信息
	private ProRankVO proRankVO;                 //服务者专业技术职务等级信息
}
