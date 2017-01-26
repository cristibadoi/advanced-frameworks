package com.cristibadoi.automarket.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/welcome")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView helloWorld(ModelMap model) {
		String message = "Hello World!";
		return new ModelAndView("welcome", "message", message);
	}
	
}
