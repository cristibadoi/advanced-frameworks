package com.cristibadoi.automarket.web.controllers;

import com.cristibadoi.automarket.logic.exceptions.UploadFailureException;
import com.cristibadoi.automarket.logic.input.PublishInput;
import com.cristibadoi.automarket.logic.services.ArticleService;
import com.cristibadoi.automarket.logic.services.ModelExtractorService;
import com.cristibadoi.automarket.logic.validators.ArticleValidator;
import com.cristibadoi.automarket.web.constants.WebLayerConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/publish")
public class PublishController {

  @Autowired
  private ModelExtractorService modelExtractor;

  @Autowired
  private ArticleService articleService;

  @Autowired
  private ArticleValidator articleValidator;

  @GetMapping
  public ModelAndView getPublishView() {

    ModelAndView model = new ModelAndView("publish");
    model.addObject("brands", modelExtractor.getAllBrands());
    model.addObject("models", modelExtractor.getAllModels());
    model.addObject("fuels", modelExtractor.getAllFuels());
    model.addObject("cities", modelExtractor.getAllCities());
    model.addObject("types", modelExtractor.getAllTypes());

    return model;

  }

  @PostMapping
  public ModelAndView publishArticle(@RequestParam String brand, @RequestParam String model, @RequestParam String type,
                                     @RequestParam String fuel, @RequestParam Integer year,
                                     @RequestParam Integer capacity, @RequestParam Integer mileage,
                                     @RequestParam String description, @RequestParam Integer price,
                                     @RequestParam String city, @RequestParam String phone, @RequestParam String email,
                                     @RequestParam MultipartFile[] images) throws UploadFailureException {

    PublishInput publishInput = new PublishInput();
    publishInput.setBrand(brand);
    publishInput.setModel(model);
    publishInput.setType(type);
    publishInput.setFuel(fuel);
    publishInput.setYear(year);
    publishInput.setCapacity(capacity);
    publishInput.setMileage(mileage);
    publishInput.setDescription(description);
    publishInput.setPrice(price);
    publishInput.setCity(city);
    publishInput.setPhone(phone);
    publishInput.setEmail(email);
    publishInput.setImages(images);
    articleService.saveArticle(publishInput);

    ModelAndView result = new ModelAndView("success");
    result.addObject("message", WebLayerConstants.POST_PUBLISH_SUCCESS);

    return result;

  }

}
