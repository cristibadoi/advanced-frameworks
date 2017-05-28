package com.cristibadoi.automarket.logic.services;

import com.cristibadoi.automarket.logic.data.FullArticleData;
import com.cristibadoi.automarket.logic.data.SmallArticleData;
import com.cristibadoi.automarket.logic.exceptions.ArticleNotFoundException;
import com.cristibadoi.automarket.logic.exceptions.UnauthorizedException;
import com.cristibadoi.automarket.logic.exceptions.UploadFailureException;
import com.cristibadoi.automarket.logic.input.PublishInput;
import com.cristibadoi.automarket.logic.input.QueryInput;

import java.util.List;

public interface ArticleService {

  FullArticleData getFullArticleById(long id) throws ArticleNotFoundException;

  List<FullArticleData> getMatchingFullArticles(QueryInput queryInput);

  SmallArticleData getSmallArticleById(long id) throws ArticleNotFoundException;

  List<SmallArticleData> getMatchingSmallArticles(QueryInput queryInput);

  void saveArticle(PublishInput publishInput) throws UploadFailureException;
  
  void deleteArticle(long id, String action) throws UnauthorizedException;

}
