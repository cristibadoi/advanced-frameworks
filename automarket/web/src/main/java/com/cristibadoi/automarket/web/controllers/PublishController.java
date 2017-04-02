package com.cristibadoi.automarket.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cristibadoi.automarket.logic.services.FormFieldsExtractorService;

@Controller
@RequestMapping("/publish")
public class PublishController {

  @Autowired
  FormFieldsExtractorService fieldExtractor;

  @GetMapping
  public ModelAndView publishPage() {

    ModelAndView model = new ModelAndView("publish");
    model.addObject("brands", fieldExtractor.getAllBrands());
    model.addObject("models", fieldExtractor.getAllModels());
    model.addObject("fuels", fieldExtractor.getAllFuels());
    model.addObject("cities", fieldExtractor.getAllCities());

    return model;

  }

  @PostMapping
  public ModelAndView publishPost() {

    ModelAndView model = new ModelAndView("success");
    model.addObject("message", "SUCCESS! Your post has been published!");

    return model;

  }

}
