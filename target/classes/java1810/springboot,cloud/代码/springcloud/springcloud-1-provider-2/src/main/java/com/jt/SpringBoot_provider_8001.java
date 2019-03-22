package com.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.jt.springcloud.mapper")
@EnableEurekaClient		//启动服务客户端
public class SpringBoot_provider_8001 {
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBoot_provider_8001.class, args);
	}
}
