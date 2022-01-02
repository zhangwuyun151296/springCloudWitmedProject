package com.whackon.witmed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b>智慧医疗平台信息-病人功能模块 Consumer消费者启动类</b>
 *
 * @Author 张武超
 * @Date 2021/12/29 23:30
 * @serial 1.0.0
 * @version 1.0.0
 */
//这个模块需要进行远程调用
@EnableFeignClients
//这个模块是一个客户端
@EnableEurekaClient
//这个模块是一个spring boot项目
@SpringBootApplication
public class SystemPatlentStarter {
	public static void main(String[] args) {
		SpringApplication.run(SystemPatlentStarter.class, args);
	}
}
