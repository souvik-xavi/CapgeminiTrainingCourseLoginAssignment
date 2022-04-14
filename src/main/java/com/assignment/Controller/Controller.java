package com.assignment.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.assignment.Entity.User;
import com.assignment.Service.UserService;


@RestController
public class Controller {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView Login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "Login From Here");
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("newUser");
		mv.addObject("message", "Welcome");
		return mv;
		
	}
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public ModelAndView authenticate(@RequestParam(name="uname") String userName,
									@RequestParam(name="pwd") String userPassWord) {
		ModelAndView mv = new ModelAndView();
		String au=userService.authrnticate(userName,userPassWord);
			if(au.equals("NP")) {
				mv.setViewName("login");
				mv.addObject("message", "User Not Present");
				return mv;
				
			}
			if(au.equals("NM")) {
				mv.setViewName("login");
				mv.addObject("message", "Password Didn't Match");
				return mv;
				
			}
		
		mv.setViewName("courses");
		return mv;
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@RequestParam(name="uname") String userName,
			@RequestParam(name="pwd1") String userPassWord1,@RequestParam(name="pwd2") String userPassWord2) {
		System.out.println(userName);
			ModelAndView mv = new ModelAndView();
			if(!userService.verify(userPassWord1,userPassWord2)) {
				mv.setViewName("newUser");
				mv.addObject("message", "password didn't match");
				return mv;
				
			}
			if(userService.verifyUsername(userName)) {
				mv.setViewName("newUser");
				mv.addObject("message", "User name Already taken");
				return mv;
			}
			
			User user= new User(userName,userPassWord1);
			userService.saveUser(user);
			System.out.println(user);
			mv.setViewName("courses");
				return mv;

		}

}
