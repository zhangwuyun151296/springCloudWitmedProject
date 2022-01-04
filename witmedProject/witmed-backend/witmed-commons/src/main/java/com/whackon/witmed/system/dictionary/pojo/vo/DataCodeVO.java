package com.whackon.witmed.system.dictionary.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>系统功能 - 数据元值域代码视图信息</b>
 * <p>
 *     数据元值域代码视图信息设置如下属性<br/>
 *     1、id：主键<br/>
 *     2、parent：上级数据<br/>
 *     3、code：编码<br/>
 *     4、remark：编码说明<br/>
 * </p>
 * @author 张武超
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class DataCodeVO extends BaseVO {
	private static final long serialVersionUID = 5860360312090595538L;
	private Long id;                    //主键
	private String parent;              //上级数据
	private String code;                //编码
	private String remark;              //编码说明
}
