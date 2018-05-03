package cqupt.bodybuliding.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cqupt.bodybuliding.domain.Orders;
import cqupt.bodybuliding.domain.User;
import cqupt.bodybuliding.res.UserDao;
import cqupt.bodybuliding.utils.ResponseBo;

@RestController
@Component
public class UserController {
	@Autowired
    private UserDao userdao;
	
	@RequestMapping(value="/registerUser",method=RequestMethod.GET)
	public String registerUser(@RequestParam("username")String username,@RequestParam("password")String password,
			@RequestParam("type")String type,@RequestParam("introduce")String introduce) {
		User uu=userdao.findUsername(username);
		if(uu==null) {
			User user =new User(); 
			user.setUsername(username);
			user.setPassword(password);
			user.setType(type);
			user.setIntroduce(introduce);
			User u=userdao.save(user);
			if(u!=null) {
				return ResponseBo.build(1,"成功",u).toJsonString();
			}else {
				return ResponseBo.build(0,"失败",u).toJsonString();
			}
		}else {
			return ResponseBo.build(0,"username已存在",uu).toJsonString();
		}
		
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(@RequestParam("username")String username,@RequestParam("password")String password) {
		User u=userdao.login(username, password);
		if(u!=null) {
			return ResponseBo.build(1,"成功",u).toJsonString();
		}else {
			return ResponseBo.build(0,"失败",u).toJsonString();
		}
	}
	
	@RequestMapping(value="/selectAllUser",method=RequestMethod.GET)
	public String selectAllUser() {
		List<User> l=userdao.findAll();
		return ResponseBo.build(1,"成功",l).toJsonString();
	}
}
