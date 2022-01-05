package com.whackon.witmed.system.admin.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>系统功能 - 系统菜单功能视图信息</b>
 *<p>
 *     系统菜单功能视图信息设置如下属性<br/>
 *     1、id：主键<br/>
 *     2、code：角色编码<br/>
 *     3、parent：上级菜单<br/>
 *     4、text：菜单文本<br/>
 *     5、url：链接地址<br/>
 *     6、icon：菜单图标样式<br/>
 *     7、sort：排序<br/>
 *</p>
 * @author 张武超
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class MenuVO extends BaseVO {
	private static final long serialVersionUID = -3005713927290157590L;
	private Long id;                    //主键
	private String code;                //角色编码
	private String parent;              //上级菜单
	private String text;                //菜单文本
	private String url;                 //链接地址
	private String icon;                //菜单图标样式
	private Long sort;                  //排序


}
