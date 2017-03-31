package com.cristibadoi.automarket.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/messages")
public class MessagesController {

  @RequestMapping(method = RequestMethod.GET)
  public String messagesPage() {
    return "messages";
  }
  
}
