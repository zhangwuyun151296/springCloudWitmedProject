package com.whackon.witmed.system.hospital.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>系统功能 - 医院部门视图信息</b>
 * <p>
 *     医院部门视图信息设置如下属性<br/>
 *     1、id：主键<br/>
 *     2、hospitalVO：所在医院<br/>
 *     3、parent：上级部门<br/>
 *     4、code：部门编码<br/>
 *     5、name：部门名称<br/>
 * </p>
 * @author 张武超
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class DepartmentVO extends BaseVO {
	private static final long serialVersionUID = 5422723187036639884L;
	private Long id;                    //主键
	private HospitalVO hospitalVO;      //所在医院
	private String parent;              //上级部门
	private String code;                //部门编码
	private String name;                //部门名称
}
