package cqupt.bodybuliding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cqupt.bodybuliding.domain.Orders;
import cqupt.bodybuliding.domain.User;
import cqupt.bodybuliding.res.OrdersDao;
import cqupt.bodybuliding.res.UserDao;
import cqupt.bodybuliding.utils.ResponseBo;

@RestController
@Component
public class OrderController {
	
	@Autowired
    private UserDao userdao;
	
	@Autowired
    private OrdersDao orderdao;
	

	
	@RequestMapping(value="/typeAll",method=RequestMethod.GET)
	public String typeAll() {
		List<User> u=userdao.typeAll();
		if(u!=null) {
			return ResponseBo.build(1,"成功",u).toJsonString();
		}else {
			return ResponseBo.build(0,"失败",u).toJsonString();
		}
	}
	
	@RequestMapping(value="/type",method=RequestMethod.GET)
	public String type(@RequestParam("type")String type1) {
		List<User> u=userdao.type(type1);
		if(u!=null) {
			return ResponseBo.build(1,"成功",u).toJsonString();
		}else {
			return ResponseBo.build(0,"失败",u).toJsonString();
		}
	}
	
	@RequestMapping(value="/appointment",method=RequestMethod.GET)
	public String appointment(@RequestParam("username1")String username1,@RequestParam("username2")String username2,
			@RequestParam("time")String time) {
		Orders oo=new Orders();
		oo.setTime(time);
		oo.setUsernamea(username1);
		oo.setUsernameb(username2);
		Orders u=orderdao.save(oo);
		if(u!=null) {
			return ResponseBo.build(1,"成功",u).toJsonString();
		}else {
			return ResponseBo.build(0,"失败",u).toJsonString();
		}
	}
	
	@RequestMapping(value="/selectOrderByUsername",method=RequestMethod.GET)
	public String selectOrderByUsername(@RequestParam("username1")String username1) {
		List<Orders> u=orderdao.selectOrderByUsername(username1);
		if(u!=null) {
			return ResponseBo.build(1,"成功",u).toJsonString();
		}else {
			return ResponseBo.build(0,"失败",u).toJsonString();
		}
	}
	
	@RequestMapping(value="/selectOrderByUsername1",method=RequestMethod.GET)
	public String selectOrderByUsername1(@RequestParam("username2")String username2) {
		List<Orders> u=orderdao.selectOrderByUsername1(username2);
		if(u!=null) {
			return ResponseBo.build(1,"成功",u).toJsonString();
		}else {
			return ResponseBo.build(0,"失败",u).toJsonString();
		}
	}
	
	@RequestMapping(value="/cancle",method=RequestMethod.GET)
	public String cancle(@RequestParam("orderid")Integer orderid) {
		orderdao.delete(orderid);
		return ResponseBo.build(1,"成功","").toJsonString();
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(@RequestParam("orderid")int orderid,@RequestParam("time")String time) {
		int i=orderdao.updatetime(time,orderid);
		if(i!=0) {
			Orders o=orderdao.findOne(orderid);
			if(o!=null) {
				return ResponseBo.build(1,"成功",o).toJsonString();
			}else {
				return ResponseBo.build(0,"失败",o).toJsonString();
			}
		}else {
			return ResponseBo.build(0,"更新失败","").toJsonString();
		}
	}
}
