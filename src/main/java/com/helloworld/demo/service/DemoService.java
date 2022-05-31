package com.helloworld.demo.service;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helloworld.demo.loadbalancer.LoadBalancerConfiguration;
import com.helloworld.demo.user.User;
@FeignClient("user-service")
@LoadBalancerClient(name="user-service",configuration = LoadBalancerConfiguration.class)
public interface DemoService {
	@RequestMapping("/user/id")
	public User getUserById(@PathVariable("id") Integer id);
	

}
