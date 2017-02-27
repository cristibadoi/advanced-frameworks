package com.cristibadoi.automarket.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cristibadoi.automarket.logic.query.QueryDetails;
import com.cristibadoi.automarket.logic.services.PostSearchService;

@Controller
@RequestMapping("/search")
public class SearchController {

  @Autowired
  PostSearchService service;

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView searchPost(@RequestBody QueryDetails searchData) {

    String searchResults = "results";
    return new ModelAndView("search", "results", searchResults);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ModelAndView publishPost(@RequestBody QueryDetails publishData) {

    String searchResults = "results";
    return new ModelAndView("search", "results", searchResults);
  }

}
