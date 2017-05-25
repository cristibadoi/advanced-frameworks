package com.cristibadoi.automarket.web.controllers;

import com.cristibadoi.automarket.authentication.InvalidUserException;
import com.cristibadoi.automarket.authentication.UserConstants;
import com.cristibadoi.automarket.authentication.UserService;
import com.cristibadoi.automarket.authentication.UserValidator;
import com.cristibadoi.automarket.persistence.models.UserModel;
import com.cristibadoi.automarket.web.constants.WebLayerConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
public class RegisterController {

  @Autowired
  private UserService userService;

  @Autowired
  private UserValidator userValidator;

  @GetMapping
  public String signupPage() {

    return "register";

  }

  @PostMapping
  public ModelAndView register(@RequestParam String email, @RequestParam String username, @RequestParam String password,
                               BindingResult result) throws InvalidUserException {

    ModelAndView model = new ModelAndView("redirect:/login");

    UserModel newUser = new UserModel();
    newUser.setEmail(email);
    newUser.setUsername(username);
    newUser.setPassword(password);

    userValidator.validate(newUser, result);

    if (result.hasErrors()) {
      //TO DO log specific errors
      throw new InvalidUserException(UserConstants.INVALID_USER);
    }

    userService.save(newUser);

    return model;

  }

}
