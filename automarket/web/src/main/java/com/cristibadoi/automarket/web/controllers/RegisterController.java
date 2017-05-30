package com.cristibadoi.automarket.web.controllers;

import com.cristibadoi.automarket.logic.constants.ServiceLayerConstants;
import com.cristibadoi.automarket.logic.exceptions.EmailSendingFailureException;
import com.cristibadoi.automarket.logic.services.UserService;
import com.cristibadoi.automarket.logic.validators.UserValidator;
import com.cristibadoi.automarket.persistence.models.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
public class RegisterController {

  @Autowired
  private UserService userService;

  @Autowired
  private UserValidator userValidator;

  @GetMapping
  public ModelAndView signupPage() {

    ModelAndView model = new ModelAndView("register");
    model.addObject("newUser", new UserModel());

    return model;

  }

  @PostMapping
  public ModelAndView register(@ModelAttribute("newUser") UserModel newUser, BindingResult result)
      throws EmailSendingFailureException {

    ModelAndView model;

    userValidator.validate(newUser, result);

    if (result.hasErrors()) {
      //TODO log specific errors
      model = new ModelAndView("register");
      model.addObject("message", ServiceLayerConstants.INVALID_USER_MESSAGE);
      return model;
    }

    userService.registerUser(newUser);
    model = new ModelAndView("success");
    model.addObject("message", ServiceLayerConstants.ACCOUNT_CREATION_SUCCESS_MESSAGE);
    return model;

  }

}
