package com.cristibadoi.automarket.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cristibadoi.automarket.logic.data.SmallArticleData;
import com.cristibadoi.automarket.logic.exceptions.UnauthorizedException;
import com.cristibadoi.automarket.logic.services.ArticleService;

@Controller
@RequestMapping("/account")
public class AccountController {

  @Autowired
  ArticleService articleService;

  @GetMapping("/articles")
  public ModelAndView myArticlesPage() {

    User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    List<SmallArticleData> articles = articleService.getSmallArticlesByAuthor(currentUser.getUsername());

    ModelAndView model = new ModelAndView("my-articles");
    model.addObject("articles", articles);
    model.addObject("username", currentUser.getUsername());
    return model;
  }

  @GetMapping("/articles/delete/{articleId}")
  public String deleteArticle(@PathVariable("articleId") long articleId, @RequestParam("action") String action)
      throws UnauthorizedException {

    articleService.deleteArticle(articleId, action);

    return "redirect:/account/articles";

  }

}
