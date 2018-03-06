package com.study.test.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SpringControllerTest implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String testValue = "SpringTest";
		ModelAndView mv = new ModelAndView();
		mv.addObject(testValue);
		mv.setViewName("WEB-INF/index.jsp");
		return mv;
	}
	
}