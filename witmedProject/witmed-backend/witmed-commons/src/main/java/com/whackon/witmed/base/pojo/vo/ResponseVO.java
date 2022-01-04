package com.whackon.witmed.base.pojo.vo;

import com.whackon.witmed.base.pojo.enums.ResponseCode;
import lombok.Data;

import java.io.Serializable;

/**
 * <b>基础信息功能-系统响应视图信息</b>
 * <p>
 *     系统响应视图信息设置如下属性<br/>
 *     1、code：系统响应编码<br/>
 *     2、message：系统响应结果<br/>
 *     3、data：系统响应数据<br/>
 *     本项目所有功能返回前端数据<b>都必须以本系统响应视图信息返回</b>
 * </p>
 *
 * @Author 张武超
 * @Date 2021/12/29 23:30
 * @serial 1.0.0
 * @version 1.0.0
 */
@Data
public class ResponseVO implements Serializable {
	private static final long serialVersionUID = -297922567153997117L;
	private String code;                    //系统响应编码
	private String message;                 //系统响应结果
	private Object data;                    //系统响应数据

	public ResponseVO(ResponseCode responseCode, String message, Object data) {
		this.code = responseCode.getCode();
		this.message = message;
		this.data = data;
	}

	/**
	 * 获得系统业务处理完毕，响应成功视图信息
	 * @param message
	 * @return
	 */
	public static ResponseVO success(String message){
		return new ResponseVO(ResponseCode.RESPONSE_SUCCESS,message,"");
	}

	/**
	 * 获得系统业务处理完毕，响应成功视图信息
	 * @param date
	 * @return
	 */
	public static ResponseVO success(String message,Object date){
		return new ResponseVO(ResponseCode.RESPONSE_SUCCESS,message,date);
	}

	/**
	 * 获得系统用户未进行认证响应视图信息
	 * @param
	 * @return
	 */
	public static ResponseVO unAuth(){
		return new ResponseVO(ResponseCode.RESPONSE_UNAUTH,ResponseCode.RESPONSE_UNAUTH.getRemarks(), "");
	}

	/**
	 * 获得系统业务处理错误响应视图信息
	 * @param
	 * @return
	 */
	public static ResponseVO error(String message){
		return new ResponseVO(ResponseCode.RESPONSE_ERROR, message, "");
	}
	/**
	 * 获得系统响应异常视图信息
	 * @param
	 * @return
	 */
	public static ResponseVO exception(Exception exception){
		return new ResponseVO(ResponseCode.RESPONSE_EXCEPTION,exception.getMessage(), "");
	}
}
