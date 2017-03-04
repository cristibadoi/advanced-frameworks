package com.cristibadoi.automarket.logic.services;

import com.cristibadoi.automarket.persistence.models.QPostModel;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public class PostPredicates {

  private PostPredicates() {
  }

  static Predicate createPredicate(QueryDetails queryDetails) {
    QPostModel post = QPostModel.postModel;
    BooleanBuilder builder = new BooleanBuilder();

    if (queryDetails.getBrandName() != null) {
      builder.or(post.brand.name.equalsIgnoreCase(queryDetails.getBrandName()));
    }
    if (queryDetails.getModelName() != null) {
      builder.and(post.model.name.equalsIgnoreCase(queryDetails.getModelName()));
    }
    if (queryDetails.getMinYear() != 0) {
      builder.and(post.modelYear.goe(queryDetails.getMinYear()));
    }
    if (queryDetails.getMaxYear() != 0) {
      builder.and(post.modelYear.loe(queryDetails.getMaxYear()));
    }
    if (queryDetails.getMinMileage() != 0) {
      builder.and(post.mileage.goe(queryDetails.getMinMileage()));
    }
    if (queryDetails.getMaxMileage() != 0) {
      builder.and(post.mileage.loe(queryDetails.getMaxMileage()));
    }
    if (queryDetails.getMinPrice() != 0) {
      builder.and(post.price.goe(queryDetails.getMinPrice()));
    }
    if (queryDetails.getMaxPrice() != 0) {
      builder.and(post.price.loe(queryDetails.getMaxPrice()));
    }
    if (queryDetails.getCurrency() != null) {
      builder.and(post.currency.code.equalsIgnoreCase(queryDetails.getCurrency()));
    }
    if (queryDetails.getCity() != null) {
      builder.and(post.city.name.equalsIgnoreCase(queryDetails.getCity()));
    }
    if (queryDetails.getFuel() != null) {
      builder.and(post.fuel.name.equalsIgnoreCase(queryDetails.getFuel()));
    }
    if (queryDetails.getMinCapacity() != 0) {
      builder.and(post.cylindricalCapacity.goe(queryDetails.getMinCapacity()));
    }
    if (queryDetails.getMaxCapacity() != 0) {
      builder.and(post.cylindricalCapacity.loe(queryDetails.getMaxCapacity()));
    }

    return builder.getValue();
  }

}
