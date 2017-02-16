package com.cristibadoi.automarket.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cristibadoi.automarket.logic.services.PostSearchService;

@Controller
@RequestMapping("/search")
public class SearchController {
  
  @Autowired
  PostSearchService service;

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView searchFor(ModelMap model) {
    //not yet implemented
    //will call service.findByModel() and return a .jsp with the result
    String searchResults = "results";
    return new ModelAndView("search", "results", searchResults);
  }
  
}
