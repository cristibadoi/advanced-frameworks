package com.cristibadoi.automarket.web.controllers;

import com.cristibadoi.automarket.logic.data.SmallArticleData;
import com.cristibadoi.automarket.logic.input.QueryInput;
import com.cristibadoi.automarket.logic.services.ArticleImageService;
import com.cristibadoi.automarket.logic.services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

  @Autowired
  ArticleService articleService;

  @Autowired
  ArticleImageService articleImageService;

  @GetMapping
  public ModelAndView search(@RequestParam(required = false) String brand, @RequestParam(required = false) String model,
                             @RequestParam(required = false) String type, @RequestParam(required = false) String fuel,
                             @RequestParam(required = false) Integer minCapacity,
                             @RequestParam(required = false) Integer maxCapacity,
                             @RequestParam(required = false) Integer minYear,
                             @RequestParam(required = false) Integer maxYear,
                             @RequestParam(required = false) Integer minMileage,
                             @RequestParam(required = false) Integer maxMileage,
                             @RequestParam(required = false) Integer minPrice,
                             @RequestParam(required = false) Integer maxPrice,
                             @RequestParam(required = false) String currency,
                             @RequestParam(required = false) String city) {

    QueryInput queryInput = new QueryInput();
    if (brand != null && !brand.equals("")) {
      queryInput.setBrandName(brand);
    }
    if (model != null && !model.equals("")) {
      queryInput.setModelName(model);
    }
    if (type != null && !type.equals("")) {
      queryInput.setType(type);
    }
    if (fuel != null && !fuel.equals("")) {
      queryInput.setFuel(fuel);
    }
    if (city != null && !city.equals("")) {
      queryInput.setCity(city);
    }
    if (minCapacity != null) {
      queryInput.setMinCapacity(minCapacity);
    }
    if (maxCapacity != null) {
      queryInput.setMaxCapacity(maxCapacity);
    }
    if (minYear != null) {
      queryInput.setMinYear(minYear);
    }
    if (maxYear != null) {
      queryInput.setMaxYear(maxYear);
    }
    if (minMileage != null) {
      queryInput.setMinMileage(minMileage);
    }
    if (maxMileage != null) {
      queryInput.setMaxMileage(maxMileage);
    }
    if (minPrice != null) {
      queryInput.setMinPrice(minPrice);
    }
    if (maxPrice != null) {
      queryInput.setMaxPrice(maxPrice);
    }

    List<SmallArticleData> results = articleService.getMatchingSmallArticles(queryInput);

    return new ModelAndView("search-results", "results", results);

  }

}
