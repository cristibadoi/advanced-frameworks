package com.cristibadoi.automarket.logic.services;

import org.springframework.stereotype.Service;

import com.cristibadoi.automarket.logic.constants.ServiceLayerConstants;
import com.cristibadoi.automarket.logic.input.QueryInput;
import com.cristibadoi.automarket.persistence.models.QArticleModel;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

@Service
public class ArticlePredicatesServiceImpl implements ArticlePredicatesService{

  public ArticlePredicatesServiceImpl() {
  }

  public Predicate createArticleSearchPredicate(QueryInput queryInput) {

    QArticleModel article = QArticleModel.articleModel;
    BooleanBuilder builder = new BooleanBuilder();

    if (queryInput.getBrandName() != null) {
      builder.and(article.brand.name.eq(queryInput.getBrandName()));
    }
    if (queryInput.getModelName() != null) {
      builder.and(article.model.name.eq(queryInput.getModelName()));
    }
    if (queryInput.getMinYear() > 0) {
      builder.and(article.modelYear.goe(queryInput.getMinYear()));
    }
    if (queryInput.getMaxYear() > 0) {
      builder.and(article.modelYear.loe(queryInput.getMaxYear()));
    }
    if (queryInput.getMinMileage() > 0) {
      builder.and(article.mileage.goe(queryInput.getMinMileage()));
    }
    if (queryInput.getMaxMileage() > 0) {
      builder.and(article.mileage.loe(queryInput.getMaxMileage()));
    }
    if (queryInput.getMinPrice() > 0) {
      builder.and(article.price.goe(queryInput.getMinPrice()));
    }
    if (queryInput.getMaxPrice() > 0) {
      builder.and(article.price.loe(queryInput.getMaxPrice()));
    }
    if (queryInput.getType() != null) {
      builder.and(article.type.name.eq(queryInput.getType()));
    }
    if (queryInput.getCity() != null) {
      builder.and(article.city.name.eq(queryInput.getCity()));
    }
    if (queryInput.getFuel() != null) {
      builder.and(article.fuel.name.eq(queryInput.getFuel()));
    }
    if (queryInput.getMinCapacity() > 0) {
      builder.and(article.cylindricalCapacity.goe(queryInput.getMinCapacity()));
    }
    if (queryInput.getMaxCapacity() > 0) {
      builder.and(article.cylindricalCapacity.loe(queryInput.getMaxCapacity()));
    }
    builder.and(article.status.name.eq(ServiceLayerConstants.ARTICLE_STATUS_ACTIVE));

    return builder.getValue();

  }

  public Predicate createUserPredicate(String username) {

    QArticleModel article = QArticleModel.articleModel;
    BooleanBuilder builder = new BooleanBuilder();

    builder.and(article.user.username.eq(username));
    builder.and(article.status.name.eq(ServiceLayerConstants.ARTICLE_STATUS_ACTIVE));

    return builder.getValue();

  }

}
