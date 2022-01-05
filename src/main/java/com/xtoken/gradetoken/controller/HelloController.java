package com.xtoken.gradetoken.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author
 * @since 1.0.0
 */
@Api("HelloController")
@RestController
@RequestMapping("/test")
public class HelloController {

	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}
}