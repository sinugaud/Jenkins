package com.helloworld.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helloworld.demo.service.DemoService;
import com.helloworld.demo.user.User;

@RestController
//@RequestMapping("/api/v1/greet")
public class HelloWorldController {
	@Autowired
	private DemoService demoService;

	@GetMapping("/greeting")
	public String greetings() {
		return "Hello World ";

	}

	static HashMap<Integer, User> userData = new HashMap();
	static {
		userData.put(1, new User(1, "Shau", "DC"));
		userData.put(2, new User(2, "John", "SFO"));
		userData.put(3, new User(3, "Steave Italy", "DC"));
		userData.put(4, new User(4, "Bibwer", "NY"));
	}

	@RequestMapping("/city/user/{id}")
	public List<User> getCityforUser(@PathVariable("id") Integer id) {
		System.out.println("Got request for user with id: " + id);
		String userCity = demoService.getUserById(id).getCity();
		return userData.entrySet().stream().filter(entry -> entry.getValue().getCity().equals(userCity))
				.map(entry -> entry.getValue()).collect(Collectors.toList());
	}
}
