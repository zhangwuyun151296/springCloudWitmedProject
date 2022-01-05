package com.whackon.witmed.controller;

import com.whackon.witmed.base.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>智慧医疗信息平台-</b>
 *
 * @version 1.0.0
 * @Author 张武超
 * @Date 2022/1/4
 * @serial 1.0.0
 */
@RestController
public class TestController {
	//引入雪花算法工具类
	@Autowired
	private IdGenerator idGenerator;
	@GetMapping("/id")
	public String createId()throws Exception{
		return idGenerator.createId();
	}



}
