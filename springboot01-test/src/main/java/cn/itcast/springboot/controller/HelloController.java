package cn.itcast.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
	
	@Autowired
	private Environment environment;
	@Value("${name}")
	private String name;
	@Value("${url}")
	private String url;
	
	// http://localhost:8080/hello
	@GetMapping("/hello")
	public String hello(){
		System.out.println(environment.getProperty("name"));
		System.out.println(environment.getProperty("url"));
		System.out.println(name);
		System.out.println(url);
		return "Hello World";
	}
	
	// 响应数据为静态html页面： http://localhost:8080/user
	@GetMapping("/user")
	public String user(){
		System.out.println("...............");
		return "/html/user.html";
	}


}
