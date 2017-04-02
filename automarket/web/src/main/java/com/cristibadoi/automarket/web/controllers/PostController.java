package com.cristibadoi.automarket.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cristibadoi.automarket.logic.exceptions.PostNotFoundException;
import com.cristibadoi.automarket.logic.services.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

  @Autowired
  PostService postService;

  @GetMapping(value = "/{postId}")
  public ModelAndView getPostPage(@PathVariable(value = "postId") long id) throws PostNotFoundException {

    ModelAndView model = new ModelAndView("post");
    model.addObject("post", postService.getPostById(id));
    
    return model;

  }

}
