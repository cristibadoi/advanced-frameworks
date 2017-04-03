package com.cristibadoi.automarket.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cristibadoi.automarket.logic.exceptions.NoResultsFoundException;
import com.cristibadoi.automarket.logic.query.QueryDetails;
import com.cristibadoi.automarket.logic.services.PostService;

@Controller
@RequestMapping("/search")
public class SearchController {

  @Autowired
  PostService service;

  @GetMapping
  public ModelAndView search(@RequestParam(required = false) String brand, @RequestParam(required = false) String model,
      @RequestParam(required = false) String type, @RequestParam(required = false) String fuel,
      @RequestParam(required = false) Integer minCapacity, @RequestParam(required = false) Integer maxCapacity,
      @RequestParam(required = false) Integer minYear, @RequestParam(required = false) Integer maxYear,
      @RequestParam(required = false) Integer minMileage, @RequestParam(required = false) Integer maxMileage,
      @RequestParam(required = false) Integer minPrice, @RequestParam(required = false) Integer maxPrice,
      @RequestParam(required = false) String currency, @RequestParam(required = false) String city)
      throws NoResultsFoundException {

    QueryDetails queryDetails = new QueryDetails();
    if (brand != null) {
      queryDetails.setBrandName(brand);
    }
    if (model != null) {
      queryDetails.setModelName(model);
    }
    if (type != null) {
      queryDetails.setType(type);
    }
    if (fuel != null) {
      queryDetails.setFuel(fuel);
    }
    if (city != null) {
      queryDetails.setCity(city);
    }
    if (minCapacity != null) {
      queryDetails.setMinCapacity(minCapacity);
    }
    if (maxCapacity != null) {
      queryDetails.setMaxCapacity(maxCapacity);
    }
    if (minYear != null) {
      queryDetails.setMinYear(minYear);
    }
    if (maxYear != null) {
      queryDetails.setMaxYear(maxYear);
    }
    if (minMileage != null) {
      queryDetails.setMinMileage(minMileage);
    }
    if (maxMileage != null) {
      queryDetails.setMaxMileage(maxMileage);
    }
    if (minPrice != null) {
      queryDetails.setMinPrice(minPrice);
    }
    if (maxPrice != null) {
      queryDetails.setMaxPrice(maxPrice);
    }

    return new ModelAndView("search-results", "results", service.getMatchingPosts(queryDetails));

  }

}
