package com.whackon.witmed.system.admin.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>系统功能 - 系统用户角色视图信息</b>
 * <p>
 *     系统用户角色视图信息设置如下属性<br/>
 *     1、id：主键<br/>
 *     2、code：角色编码<br/>
 *     3、name：角色名称<br/>
 * </p>
 * @author 张武超
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class RoleVO extends BaseVO {
	private static final long serialVersionUID = -5941238169797621505L;
	private Long id;                    //主键
	private String code;                //角色编码
	private String name;                //角色名称
}
