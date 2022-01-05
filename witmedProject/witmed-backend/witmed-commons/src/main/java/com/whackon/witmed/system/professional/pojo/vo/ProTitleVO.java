package com.whackon.witmed.system.professional.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>系统功能 - 专业职务视图信息</b>
 * <p>
 *     专业职务等级视图信息设置如下属性<br/>
 *     1、id：主键<br/>
 *     2、proCategoryVO：所属类别<br/>
 *     3、proRankVO：所属等级<br/>
 *     4、code：编码<br/>
 *     5、name：名称<br/>
 * </p>
 * @author 张武超
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class ProTitleVO extends BaseVO {
	private static final long serialVersionUID = -5717484475516625907L;
	private Long id;                        //主键
	private ProCategoryVO proCategoryVO;    //所属类别
	private ProRankVO proRankVO;            //所属等级
	private String code;                    //专业职务编码
	private String name;                    //专业职务名称
}
