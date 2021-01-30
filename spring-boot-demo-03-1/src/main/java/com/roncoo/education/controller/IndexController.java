/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.roncoo.education.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roncoo.education.bean.User;

/**
 * spring-boot-demo-3-1
 * 配置文件详解：Properties 学习
 * 1.配置文件application.properties
 * 2. 启动时候制定配置文件： java -jar xxxx.jar --spring.config.location=/etc/spring/application.properties
 * 3.配置文件优先级 ，关注4个 application.properties 的第一行注释，放置的不同位置影响优先级 ，高优先级的配置覆盖低优先级的配置，所有的配置会形成互补配置。
 * 4.所有配置可以用从命令行制定
 * 5.配置总体加载规则 由jar包外向jar包内进行寻找，优先加载带profile的，再加载不带profile的。
 * @author wujing
 */
@RestController
@RequestMapping(value = "/index")
public class IndexController {

	//@Value("${roncoo.secret}") 根据application.properties的 key-value直接注入 secret
	@Value(value = "${roncoo.secret}")
	private String secret;
	//@Value("${roncoo.number}") 根据application.properties的 key-value直接注入 id
	@Value(value = "${roncoo.number}")
	private int id;
	//@Value("${roncoo.desc}") 根据application.properties的 key-value直接注入 desc
	@Value(value = "${roncoo.desc}")
	private String desc;

	@RequestMapping
	public String index() {
		return "hello world";
	}

	// @RequestParam 简单类型的绑定，可以出来get和post
	@RequestMapping(value = "/get")

	// return ： {"name":"chaosju","secret":"907079a2529927f51fa439063f6d13d5","id":1624519554,"title":"hello world","desc":"the domain is www.roncoo.com"}
	public HashMap<String, Object> get(@RequestParam String name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "hello world");
		map.put("name", name);
		map.put("secret", secret);
		map.put("id", id);
		map.put("desc", desc);
		return map;
	}

	// @PathVariable 获得请求url中的动态参数
	@RequestMapping(value = "/get/{id}/{name}")
	public User getUser(@PathVariable int id, @PathVariable String name) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setDate(new Date());
		return user;
	}

}
