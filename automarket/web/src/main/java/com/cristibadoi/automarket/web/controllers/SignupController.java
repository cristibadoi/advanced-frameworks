package com.cristibadoi.automarket.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cristibadoi.automarket.authentication.SecurityService;
import com.cristibadoi.automarket.authentication.UserService;
import com.cristibadoi.automarket.authentication.UserValidator;
import com.cristibadoi.automarket.persistence.models.UserModel;

@Controller
@RequestMapping("/signup")
public class SignupController {

  @Autowired
  private UserService userService;

  @Autowired
  private SecurityService securityService;

  @Autowired
  private UserValidator userValidator;

  @RequestMapping(method = RequestMethod.GET)
  public String signupPage() {
    return "signup";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String registration(@ModelAttribute("userForm") UserModel userForm, BindingResult bindingResult, Model model) {
    userValidator.validate(userForm, bindingResult);

    if (bindingResult.hasErrors()) {
      return "registration";
    }

    userService.save(userForm);

    securityService.autologin(userForm.getUsername(), userForm.getPassword());

    return "redirect:/";
  }

}
