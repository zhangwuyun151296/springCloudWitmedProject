package com.whackon.witmed.system.hospital.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>系统功能 - 医院实体信息</b>
 * <p>
 *     医院部门实体信息设置如下属性<br/>
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
 *     14、divisionCode：行政区划代码<br/>
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
@TableName(value = "sys_hospital")
public class Hospital extends BaseEntity {
	private static final long serialVersionUID = 4157247398597811639L;
	@TableId(value = "id",type = IdType.AUTO)
	private Long id;                    //主键
	@TableField(value = "name")
	private String name;                //机构名称
	@TableField(value = "authority")
	private String authority;           //上级主管机构名称
	@TableField(value = "orgCode")
	private String orgCode;             //组织机构代码
	@TableField(value = "charge")
	private String charge;              //机构负责人
	@TableField(value = "addressCatCode")
	private String addressCatCode;      //标识地址类别的代码
	@TableField(value = "provence")
	private String provence;            //所在省
	@TableField(value = "city")
	private String city;                //所在城市
	@TableField(value = "county")
	private String county;              //所在区县
	@TableField(value = "town")
	private String town;                //地址-乡（镇、街道办事处）
	@TableField(value = "village")
	private String village;             //地址-村（街、路、弄等）
	@TableField(value = "doorNo")
	private String doorNo;              //地址-门牌号码
	@TableField(value = "zipCode")
	private String zipCode;             //邮政编码
	@TableField(value = "divisionCode")
	private String divisionCode;        //行政区划代码
	@TableField(value = "telephoneCat")
	private String telephoneCat;        //联系电话-类别信息
	@TableField(value = "telephone")
	private String telephone;           //联系电话-号码
	@TableField(value = "email")
	private String email;               //电子邮件地址
 }
