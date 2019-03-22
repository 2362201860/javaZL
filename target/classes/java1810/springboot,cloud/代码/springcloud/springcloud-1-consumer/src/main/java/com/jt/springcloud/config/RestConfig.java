package com.jt.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

//一般使用springCloud时,如果是get请求采用Rest形式.
//如果请求是post提交时,后台直接接收JSON数据即可.
@Configuration
public class RestConfig {
	
	@Bean
	@LoadBalanced	//使用负载均衡 轮询
	public RestTemplate getBean() {
		
		return new RestTemplate();
	}
	
	@Bean
	public IRule myRule() {
		
		return new RoundRobinRule();     //轮询策略
		//return new RandomRule();		 //随机策略
		//return new AvailabilityFilteringRule(); //首先会过滤掉故障机或者并发链接数超过阈值的服务器.剩余的机器轮询配置
		//new WeightedResponseTimeRule();	 //服务器影响时间越快,则权重越高
		//new BestAvailableRule();          //最大可用策略，即先过滤出故障服务器后，选择一个当前并发请求数最小的;
	}
}
