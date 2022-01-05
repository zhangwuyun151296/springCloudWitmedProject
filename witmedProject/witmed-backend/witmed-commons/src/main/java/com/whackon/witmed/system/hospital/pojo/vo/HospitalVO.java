package com.whackon.witmed.system.hospital.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import com.whackon.witmed.system.dictionary.pojo.vo.DivisionVO;
import lombok.Data;

/**
 * <b>系统功能 - 医院视图信息</b>
 * <p>
 *     医院部门视图信息设置如下属性<br/>
 *     1、id：主键<br/>
 *     2、name：机构名称<br/>
 *     3、authority：上级主管机构名称<br/>
 *     4、orgCode：组织机构代码<br/>
 *     5、charge：机构负责人<br/>
 *     6、addressCatCode：标识地址类别的代码<br/>
 *     7、provence：所在省<br/>
 *     8、city：所在城市<br/>
 *     9、county：所在区县<br/>
 *     10、town：地址-乡（镇、街道办事处）<br/>
 *     11、village：地址-村（街、路、弄等）<br/>
 *     12、doorNo：地址-门牌号码<br/>
 *     13、zipCode：邮政编码<br/>
 *     14、divisionVO：行政区划代码<br/>
 *     15、telephoneCat：联系电话-类别信息<br/>
 *     16、telephone：联系电话-号码<br/>
 *     17、email：电子邮件地址<br/>
 * </p>
 * @author 张武超
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class HospitalVO extends BaseVO {
	private static final long serialVersionUID = -5604109754746085573L;
	private Long id;                    //主键
	private String name;                //机构名称
	private String authority;           //上级主管机构名称
	private String orgCode;             //组织机构代码
	private String charge;              //机构负责人
	private String addressCatCode;      //标识地址类别的代码
	private String provence;            //所在省
	private String city;                //所在城市
	private String county;              //所在区县
	private String town;                //地址-乡（镇、街道办事处）
	private String village;             //地址-村（街、路、弄等）
	private String doorNo;              //地址-门牌号码
	private String zipCode;             //邮政编码
	private DivisionVO divisionVO;      //行政区划代码
	private String telephoneCat;        //联系电话-类别信息
	private String telephone;           //联系电话-号码
	private String email;               //电子邮件地址
}
