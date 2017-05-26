package com.cristibadoi.automarket.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cristibadoi.automarket.logic.exceptions.ArticleNotFoundException;
import com.cristibadoi.automarket.logic.services.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

  @Autowired
  ArticleService articleService;

  @GetMapping(value = "/{articleId}")
  public ModelAndView getPostPage(@PathVariable(value = "articleId") long id) throws ArticleNotFoundException {

    ModelAndView model = new ModelAndView("article");
    model.addObject("article", articleService.getFullArticleById(id));

    return model;

  }

}
