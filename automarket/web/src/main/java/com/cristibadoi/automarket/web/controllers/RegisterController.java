package com.cristibadoi.automarket.web.controllers;

import com.cristibadoi.automarket.authentication.InvalidUserException;
import com.cristibadoi.automarket.authentication.UserConstants;
import com.cristibadoi.automarket.authentication.UserService;
import com.cristibadoi.automarket.authentication.UserValidator;
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
      throws InvalidUserException {

    ModelAndView model = new ModelAndView("redirect:/login");

    userValidator.validate(newUser, result);

    if (result.hasErrors()) {
      //TODO log specific errors
      throw new InvalidUserException(UserConstants.INVALID_USER);
    }

    userService.save(newUser);

    return model;

  }

}
