package com.jt.springcloud.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jt.springcloud.pojo.User;
import com.jt.springcloud.service.UserService;

import feign.hystrix.FallbackFactory;
@Component		//交给Spring容器管理
public class UserFallbackFactory 
				implements FallbackFactory<UserService>{

	@Override
	public UserService create(Throwable cause) {
		
		return new UserService() {
			//该接口方法,完成当提供者出错时,返回的有效数据
			@Override
			public String saveUser(User user) {
				
				return "后台服务器异常";
			}
			
			@Override
			public List<User> findAll() {
				List<User> userList = 
						new ArrayList<User>();
				User user = new User();
				user.setId(0).setName("后台服务器异常").setAge(0)
				.setSex("");
				userList.add(user);
				return userList;
			}
		};
	}

}
