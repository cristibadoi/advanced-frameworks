package com.cristibadoi.automarket.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cristibadoi.automarket.logic.exceptions.UnauthorizedException;
import com.cristibadoi.automarket.logic.services.ArticleService;

@Controller
@RequestMapping("/account")
public class AccountController {
  
  @Autowired
  ArticleService articleService;

  @GetMapping("/articles")
  public String myArticlesPage() {
    return "my-articles";
  }
  
  @GetMapping("/articles/delete/{articledId}") 
  public String deleteArticle(@PathVariable("articleId") long articleId, @RequestParam("action") String action) throws UnauthorizedException{
    
    articleService.deleteArticle(articleId, action);
    
    return "my-articles";
  }
  
}
