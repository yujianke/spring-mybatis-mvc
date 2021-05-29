package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONObject;
import model.User;
@Controller
public class TestWorkController{
	/**
	 * 
	 * @return Bean
	 */
	@RequestMapping("/Test")
	@ResponseBody
	public User test() {
		User User = new User();
		User.setUsername("haha");
		return User;
	}	
	
	
	@RequestMapping("/Test1/{username}/{age}")
	@ResponseBody
	public User test1(@PathVariable String age,@PathVariable String username) {
		System.out.println(username);
		User User = new User();
		User.setUsername("haha");
		return User;
	}	
	/**
	 * 
	 * @return Bean List
	 */
	@RequestMapping("/TestList")
	@ResponseBody
	public List<User>  testList (){
	List<User> UserList=new ArrayList<User>();
	User User1=new User();
	User1.setUsername("haha");
	User User2=new User();
	User2.setUsername("hehe");
	UserList.add(User1);
	UserList.add(User2);
	return UserList;
	}	
	
	/**
	 * 
	 * @return JSON Data
	 */
	@RequestMapping("/TestJSONObject")	
	public void  testReturrnJSONWithoutBean(HttpServletRequest request,HttpServletResponse response) throws IOException{
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		PrintWriter writer=response.getWriter();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("name","hehe jsonobject");
		writer.println(jsonObject.toString());
		writer.close();
		}
	
	/**
	 * 
	 * @return String
	 */	
	@RequestMapping("/TestReturnPage")
	@ResponseBody
	public String  testReturrnPage(){
	return "/testpage";
	}	
	
	/**
	 * The difference between model and modelandview is just sematic
	 * */ 
	/**
	 * @return JSON ModelAndView
	 */
	@RequestMapping("/TestReturnModel")
	public String testReturnModel(Model model) {
		User user = new User();
		user.setUsername("haha");
		model.addAttribute("user", user);
		return "testpage";
	}
	/**
	 * The difference between model and modelandview is just sematic
	 * */ 
	/**
	 * @return JSON ModelAndView
	 */
	@RequestMapping("/TestReturnModelAndView")
	public ModelAndView  testReturnModelAndView(){
		ModelAndView mav = new ModelAndView("testpage");
		mav.addObject("testmodel", "hello test model");
		return mav;
		}	
	}