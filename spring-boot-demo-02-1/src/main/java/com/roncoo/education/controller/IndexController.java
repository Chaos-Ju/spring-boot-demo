/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.roncoo.education.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roncoo.education.bean.User;

/**
 * spring-boot-demo-2-1
 * @RequestMapping此注解即可以作用在控制器的某个方法上，也可以作用在此控制器类上。
 * 当控制器在类级别上添加@RequestMapping注解时，这个注解会应用到控制器的所有处理器方法上。
 * 处理器方法上的@RequestMapping注解会对类级别上的@RequestMapping的声明进行补充。
 *
 * @PathVariable  获得请求url中的动态参数
 *
 * @author wujing
 */
@RestController
@RequestMapping(value = "/index")
public class IndexController {

	@RequestMapping
	public String index() {
		return "hello world";
	}

	//@RequestParam 简单类型的绑定，可以出来get和post
	//请求url：localhost:8080/index/get?name=chaosju。
	//响应结果是： {"name":"chaosju","title":"hello world"}
	@RequestMapping(value = "/get")
	public HashMap<String, Object> get(@RequestParam String name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "hello world");
		map.put("name", name);
		return map;
	}

	//@PathVariable 获得请求url中的动态参数
	//请求url： localhost:8080/index/get/123456/chaos。
	//响应结果：{"id":123456,"name":"chaosju","date":"2021-01-30T05:15:07.026+0000"}
	@RequestMapping(value = "/get/{id}/{name}")
	public User getUser(@PathVariable int id, @PathVariable String name) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setDate(new Date());
		return user;
	}

}
