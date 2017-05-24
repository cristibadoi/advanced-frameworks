package com.cristibadoi.automarket.logic.input;

import org.springframework.stereotype.Component;

import com.cristibadoi.automarket.persistence.models.QArticleModel;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

@Component
public class ArticlePredicates {

  public ArticlePredicates() {
  }

  public Predicate createPredicate(QueryInput queryInput) {

    QArticleModel post = QArticleModel.articleModel;
    BooleanBuilder builder = new BooleanBuilder();

    if (queryInput.getBrandName() != null) {
      builder.and(post.brand.name.eq(queryInput.getBrandName()));
    }
    if (queryInput.getModelName() != null) {
      builder.and(post.model.name.eq(queryInput.getModelName()));
    }
    if (queryInput.getMinYear() > 0) {
      builder.and(post.modelYear.goe(queryInput.getMinYear()));
    }
    if (queryInput.getMaxYear() > 0) {
      builder.and(post.modelYear.loe(queryInput.getMaxYear()));
    }
    if (queryInput.getMinMileage() > 0) {
      builder.and(post.mileage.goe(queryInput.getMinMileage()));
    }
    if (queryInput.getMaxMileage() > 0) {
      builder.and(post.mileage.loe(queryInput.getMaxMileage()));
    }
    if (queryInput.getMinPrice() > 0) {
      builder.and(post.price.goe(queryInput.getMinPrice()));
    }
    if (queryInput.getMaxPrice() > 0) {
      builder.and(post.price.loe(queryInput.getMaxPrice()));
    }
    if (queryInput.getType() != null) {
      builder.and(post.type.name.eq(queryInput.getType()));
    }
    if (queryInput.getCity() != null) {
      builder.and(post.city.name.eq(queryInput.getCity()));
    }
    if (queryInput.getFuel() != null) {
      builder.and(post.fuel.name.eq(queryInput.getFuel()));
    }
    if (queryInput.getMinCapacity() > 0) {
      builder.and(post.cylindricalCapacity.goe(queryInput.getMinCapacity()));
    }
    if (queryInput.getMaxCapacity() > 0) {
      builder.and(post.cylindricalCapacity.loe(queryInput.getMaxCapacity()));
    }

    return builder.getValue();

  }

}
