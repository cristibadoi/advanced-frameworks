package com.cristibadoi.automarket.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cristibadoi.automarket.logic.services.ModelExtractorService;

@Controller
@RequestMapping("/")
public class HomeController {

  @Autowired
  ModelExtractorService fieldExtractor;

  @GetMapping
  public ModelAndView homePage() {

    ModelAndView model = new ModelAndView("home");
    model.addObject("brands", fieldExtractor.getAllBrands());
    model.addObject("models", fieldExtractor.getAllModels());
    model.addObject("fuels", fieldExtractor.getAllFuels());
    model.addObject("cities", fieldExtractor.getAllCities());
    model.addObject("types", fieldExtractor.getAllTypes());

    return model;

  }

}
