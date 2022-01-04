package com.whackon.witmed.base.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <b>基础信息功能-系统分页视图信息</b>
 * <p>
 *     系统分页视图信息设置如下属性<br/>
 *     1、pageNum：当前页吗<br/>
 *     2、pageSize：每页的数量<br/>
 *     3、size：当前页的数量<br/>
 *     4、startRow：当前页面第一个元素在数据库中的行号<br/>
 *     5、endRow：当前页面最后一个元素在数据库中的行号<br/>
 *     6、total：总记录数<br/>
 *     7、pages：总页数<br/>
 *     8、list：分页列表<br/>
 *     9、prePage：前一页<br/>
 *     10、nextPage：下一页<br/>
 *     11、isFirstPage：是否为第一页<br/>
 *     12、isLastPage：是否为最后一页<br/>
 *     13、hasPreviousPage：是否有前一页<br/>
 *     14、hasNextPage：是否有下一页<br/>
 *     15、navigatePages：导航页码数<br/>
 *     16、navigatepageNums：所有导航页号<br/>
 *     17、navigateFirstPage：导航条上的第一页<br/>
 *     18、navigateLastPage：导航条上的最后一页<br/>
 *     本项目所有功能分页视图信息<b>都必以本系统分页视图信息进行封装</b>
 * </p>
 *
 * @version 1.0.0
 * @Author 张武超
 * @Date 2021/12/29 23:30
 * @serial 1.0.0
 */
//E:\作业\springBoot\addrook-backend
@Data
public class PageVO<E extends BaseVO> implements Serializable {
	private static final long serialVersionUID = 5060709901707944667L;
	private Integer pageNum;                        //当前页吗
	private Integer pageSize;                       //每页的数量
	private Integer size;                           //当前页的数量
	//由于startRow和endRow不常用，这里说个具体的用法
	//可以在页面中"显示startRow到endRow 共size条数据"
	private Long startRow;                          //当前页面第一个元素在数据库中的行号
	private Long endRow;                            //当前页面最后一个元素在数据库中的行号
	private Long total;                             //总记录数
	private Integer pages;                          //总页数
	private List<E> list;                           //分页列表
	private Integer prePage;                        //前一页
	private Integer nextPage;                       //下一页
	private Boolean isFirstPage = false;            //是否为第一页
	private Boolean isLastPage = false;             //是否为最后一页
	private Boolean hasPreviousPage = false;        //是否有前一页
	private Boolean hasNextPage = false;            //是否有下一页
	private Integer navigatePages;                  //导航页码数
	private Integer[] navigatepageNums;             //所有导航页号
	private Integer navigateFirstPage;              //导航条上的第一页
	private Integer navigateLastPage;               //导航条上的最后一页

	public PageVO() {}

	public PageVO(Integer pageNum, Integer pageSize) {
		if (pageNum != null && pageNum > 0) {
			this.pageNum = pageNum;
		} else {
			this.pageNum = 1;
		}

		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		} else {
			this.pageSize = 5;
		}

	}
}
