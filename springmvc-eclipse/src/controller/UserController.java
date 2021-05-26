package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.User;
import service.IuserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	IuserService userservice;
	@RequestMapping("/findbyId")
	@ResponseBody
	public User findbyId(@RequestParam String username){
		
		return userservice.findbyId(username);
	}

}
