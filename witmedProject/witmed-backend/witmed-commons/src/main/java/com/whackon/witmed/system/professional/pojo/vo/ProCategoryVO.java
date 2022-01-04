package com.whackon.witmed.system.professional.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>系统功能 - 专业职务类别视图信息</b>
 * <p>
 *     专业职务类别视图信息设置如下属性<br/>
 *     1、id：主键<br/>
 *     2、code：编码<br/>
 *     3、name：名称<br/>
 * </p>
 * @author 张武超
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class ProCategoryVO extends BaseVO {
	private static final long serialVersionUID = -7472848463806780173L;
	private Long id;                    //主键
	private String code;                //编码
	private String name;                //名称
}
