package com.cristibadoi.automarket.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cristibadoi.automarket.logic.services.PostSearchService;
import com.cristibadoi.automarket.logic.query.QueryDetails;

@Controller
@RequestMapping("/search")
public class SearchController {

  @Autowired
  PostSearchService service;

  @RequestMapping(method = RequestMethod.POST)
  public ModelAndView searchPosts(@RequestBody QueryDetails queryDetails) {
    return new ModelAndView("search", "searchResults", service.getMatchingPosts(queryDetails));
  }

}
