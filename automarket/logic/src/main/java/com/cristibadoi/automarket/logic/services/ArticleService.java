package com.cristibadoi.automarket.logic.services;

import java.util.List;

import com.cristibadoi.automarket.logic.data.FullArticleData;
import com.cristibadoi.automarket.logic.exceptions.NoResultsFoundException;
import com.cristibadoi.automarket.logic.exceptions.ArticleNotFoundException;
import com.cristibadoi.automarket.logic.exceptions.UploadFailureException;
import com.cristibadoi.automarket.logic.input.PublishInput;
import com.cristibadoi.automarket.logic.input.QueryInput;
import com.cristibadoi.automarket.persistence.models.ArticleModel;

public interface ArticleService {

  FullArticleData getPostById(long id) throws ArticleNotFoundException;

  List<FullArticleData> getMatchingPosts(QueryInput queryInput) throws NoResultsFoundException;

  void saveArticle(PublishInput publishInput) throws UploadFailureException;

}
