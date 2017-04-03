package com.cristibadoi.automarket.web.controllers;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cristibadoi.automarket.logic.constants.ServiceLayerConstants;
import com.cristibadoi.automarket.logic.exceptions.UploadFailureException;
import com.cristibadoi.automarket.logic.services.ImageUploadService;
import com.cristibadoi.automarket.logic.services.ModelExtractorService;
import com.cristibadoi.automarket.logic.services.PostService;
import com.cristibadoi.automarket.persistence.models.PostModel;
import com.cristibadoi.automarket.web.constants.WebLayerConstants;

@Controller
@RequestMapping("/publish")
public class PublishController {

  @Autowired
  ModelExtractorService modelExtractor;

  @Autowired
  PostService postService;

  @Autowired
  ImageUploadService imageUploadService;

  @GetMapping
  public ModelAndView publishPage() {

    ModelAndView model = new ModelAndView("publish");
    model.addObject("brands", modelExtractor.getAllBrands());
    model.addObject("models", modelExtractor.getAllModels());
    model.addObject("fuels", modelExtractor.getAllFuels());
    model.addObject("cities", modelExtractor.getAllCities());
    model.addObject("types", modelExtractor.getAllTypes());

    return model;

  }

  @Transactional
  @PostMapping
  public ModelAndView publishPost(@RequestParam String brand, @RequestParam String model, @RequestParam String type,
      @RequestParam String fuel, @RequestParam Integer year, @RequestParam Integer capacity,
      @RequestParam Integer mileage, @RequestParam String description, @RequestParam Integer price,
      @RequestParam String city, @RequestParam String phone, @RequestParam String email,
      @RequestParam MultipartFile[] images) throws UploadFailureException {

    User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    long unixTime = new Date().getTime() / 1000;
    String rootPath = System.getProperty(ServiceLayerConstants.CATALINA_HOME);
    String imagesParentFolder = ServiceLayerConstants.LOCAL_IMAGES_PARENT_FOLDER;
    File folder = new File(
        rootPath + File.separator + imagesParentFolder + File.separator + currentUser.getUsername() + unixTime);

    imageUploadService.uploadFiles(folder, images);
    
    PostModel post = new PostModel();
    post.setUser(modelExtractor.findUserByUsername(currentUser.getUsername()));
    post.setBrand(modelExtractor.findBrandByName(brand));
    post.setModel(modelExtractor.findModelByName(model));
    post.setType(modelExtractor.findTypeByName(type));
    post.setFuel(modelExtractor.findFuelByName(fuel));
    post.setCity(modelExtractor.findCityByName(city));
    post.setStatus(modelExtractor.findStatusByName(WebLayerConstants.POST_STATUS_ACTIVE));
    post.setModelYear(year);
    post.setCylindricalCapacity(capacity);
    post.setMileage(mileage);
    post.setDescription(description);
    post.setPrice(price);
    post.setPhoneNumber(phone);
    post.setEmail(email);
    post.setImages(folder.getAbsolutePath());
    post.setPublicationDate((int) unixTime);
    
    postService.save(post);

    ModelAndView result = new ModelAndView("success");
    result.addObject("message", WebLayerConstants.POST_PUBLISH_SUCCESS);

    return result;

  }

}
