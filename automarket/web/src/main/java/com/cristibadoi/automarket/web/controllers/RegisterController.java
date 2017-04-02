package com.cristibadoi.automarket.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cristibadoi.automarket.authentication.UserService;
import com.cristibadoi.automarket.persistence.models.UserModel;

@Controller
@RequestMapping("/register")
public class RegisterController {

  @Autowired
  private UserService userService;

  @GetMapping
  public String signupPage() {

    return "register";

  }

  @PostMapping
  public String register(@RequestParam String email, @RequestParam String username, @RequestParam String password) {

    UserModel newUser = new UserModel();
    newUser.setEmail(email);
    newUser.setUsername(username);
    newUser.setPassword(password);

    userService.save(newUser);

    return "redirect:/";
  }

}
