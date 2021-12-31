package com.whackon.witmed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <b>智慧医疗信息平台-Eureka注册中心服务器启动类</b>
 *
 * @Author 张武超
 * @Date 2021/12/29 23:30
 * @version 1.0.0
 * @serial 1.0.0
 */
@EnableEurekaServer
@SpringBootApplication
public class WitmedRegistryStarter {
	public static void main(String[] args) {
		SpringApplication.run(WitmedRegistryStarter.class, args);
	}
}
