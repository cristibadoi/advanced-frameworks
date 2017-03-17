package com.cristibadoi.automarket.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/publish")
public class PublishController {

  @RequestMapping(method = RequestMethod.GET)
  public String publishPage() {
    return "publish";
  }  
  
  @RequestMapping(method = RequestMethod.POST)
  public ModelAndView publishPost() {
    return null;
  }
  
}
