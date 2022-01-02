package com.whackon.witmed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>智慧医疗平台信息-电子病历功能模块 provider生产者启动类</b>
 *
 * @Author 张武超
 * @Date 2021/12/29 23:30
 * @serial 1.0.0
 * @version 1.0.0
 */
@MapperScan("com.whackon.witmed.*.dao")
//这个模块是一个客户端连接注册中心
@EnableEurekaClient
//这个模块是一个spring boot项目
@SpringBootApplication
public class SystemEmrStarter {
	public static void main(String[] args) {
		SpringApplication.run(SystemEmrStarter.class, args);
	}
}
