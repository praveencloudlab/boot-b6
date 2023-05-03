package com.cts.ecart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("ecart")
public class MyController {
	
	@RequestMapping(value ="/s1")
	public String f1() {
		System.out.println(">>> MyController:: f1 method");
		
		return "one";
		
	}
	
	@RequestMapping(value ="/s2")
	public String f2(Model model) {

		String user="Admin";
		model.addAttribute("userName", user); // adds to the request scope
		
		return "two";
		
	}
	
	
	@RequestMapping(value ="/s3")
	public ModelAndView f3() {
		
		ModelAndView mav=new ModelAndView();
		
		String user="Praveen";
		mav.addObject("userName", user);
		mav.setViewName("two");
	
		return mav;
		
	}

}
