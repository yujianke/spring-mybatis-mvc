package controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.User;
import service.IuserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	IuserService userservice;
	@RequestMapping(value="/findbyId",method=RequestMethod.GET)
	public User findbyId(@RequestParam("username2") String username){
		
		return userservice.findbyId(username);
	}

	@RequestMapping(value="/findbyId/{username}",method=RequestMethod.GET)
	public User findbyId2(@PathVariable("username") String user){
		
		return userservice.findbyId(user);
	}
	@RequestMapping(value="/findbyname",method=RequestMethod.GET)
	public List<User> findbyname(@RequestParam String username){
		
		return userservice.findbyname(username);
	}
	
	@GetMapping("/findbyname/{username}")
    public List<User> findbyname2(@PathVariable("username") String username,
    		                      @RequestParam("age")Integer age){
		System.out.println(age);
		return userservice.findbyname(username);
	}
	@PostMapping("/insert")
	public void insert(@RequestBody User user){
		
		userservice.insert(user);
	}
	
	
	@PostMapping("/insert2")
	public void insert2(@RequestBody User user){
		
		userservice.insert2(user);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody User user){
		
		 userservice.update(user);
	}
	
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam String username){
		
		 userservice.delete(username);
	}
	
	
}
