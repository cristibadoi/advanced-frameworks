package com.cristibadoi.automarket.web.controllers;

import com.cristibadoi.automarket.logic.exceptions.UploadFailureException;
import com.cristibadoi.automarket.logic.input.PublishInput;
import com.cristibadoi.automarket.logic.services.ArticleService;
import com.cristibadoi.automarket.logic.services.ModelExtractorService;
import com.cristibadoi.automarket.logic.validators.PublishInputValidator;
import com.cristibadoi.automarket.web.constants.WebLayerConstants;
import com.cristibadoi.automarket.web.exceptions.InvalidPublishInputException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/publish")
public class PublishController {

  @Autowired
  private ModelExtractorService modelExtractor;

  @Autowired
  private ArticleService articleService;

  @Autowired
  private PublishInputValidator publishInputValidator;

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
  public ModelAndView redirectAsModelAttribute(@RequestParam String brand, @RequestParam String model,
      @RequestParam String type, @RequestParam String fuel, @RequestParam Integer year, @RequestParam Integer capacity,
      @RequestParam Integer mileage, @RequestParam String description, @RequestParam Integer price,
      @RequestParam String city, @RequestParam String phone, @RequestParam String email,
      @RequestParam MultipartFile[] images, RedirectAttributes redirectAttributes) throws InvalidPublishInputException {

    PublishInput publishInput = new PublishInput();
    try {
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
    } catch (Exception e) {
      // TODO log all errors
      throw new InvalidPublishInputException(WebLayerConstants.INVALID_PUBLISH_INPUT_MESSAGE);
    }

    ModelAndView redirect = new ModelAndView("redirect:/publish/finalize");
    redirectAttributes.addFlashAttribute("publishInput", publishInput);
    return redirect;
  }

  @GetMapping("/finalize")
  public ModelAndView publishArticle(@ModelAttribute("publishInput") PublishInput publishInput, BindingResult result)
      throws UploadFailureException, InvalidPublishInputException {

    publishInputValidator.validate(publishInput, result);

    if (result.hasErrors()) {
      // TODO log all errors
      throw new InvalidPublishInputException(WebLayerConstants.INVALID_PUBLISH_INPUT_MESSAGE);
    }

    articleService.saveArticle(publishInput);

    ModelAndView view = new ModelAndView("success");
    view.addObject("message", WebLayerConstants.POST_PUBLISH_SUCCESS);

    return view;

  }

}
