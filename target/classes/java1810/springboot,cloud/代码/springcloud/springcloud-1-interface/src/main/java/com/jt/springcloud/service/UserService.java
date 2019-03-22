package com.jt.springcloud.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.springcloud.factory.UserFallbackFactory;
import com.jt.springcloud.pojo.User;
@FeignClient(value="provider-user",
	fallbackFactory=UserFallbackFactory.class)	
//定义当前接口访问的提供者
public interface UserService {
	
	@RequestMapping("/findAll") //提供者路径
	public List<User> findAll();
	
	@RequestMapping("/saveUser")
	public String saveUser(@RequestBody User user);
}
