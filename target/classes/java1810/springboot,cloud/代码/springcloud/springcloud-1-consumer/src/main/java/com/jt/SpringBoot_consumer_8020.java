package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//排除数据源之外加载
@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@EnableEurekaClient		//链接注册中心
@EnableFeignClients		//添加feign的支持
public class SpringBoot_consumer_8020 {
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBoot_consumer_8020.class, args);
		
	}
}
