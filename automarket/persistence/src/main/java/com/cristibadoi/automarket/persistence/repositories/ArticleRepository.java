package com.cristibadoi.automarket.persistence.repositories;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.*;
import com.cristibadoi.automarket.persistence.models.ArticleModel;

public interface ArticleRepository extends CrudRepository<ArticleModel, Long>, QueryDslPredicateExecutor<ArticleModel> {

  ArticleModel findById(long id);

  List<ArticleModel> findByUser(UserModel user);

  List<ArticleModel> findByModel(ModelModel model);

  List<ArticleModel> findByBrand(BrandModel brand);

  List<ArticleModel> findByCity(CityModel city);

  List<ArticleModel> findByStatus(StatusModel status);

  List<ArticleModel> findByFuel(FuelModel fuel);

  List<ArticleModel> findByModelYearGreaterThan(int modelYear);

  List<ArticleModel> findByModelYearLessThan(int modelYear);

  List<ArticleModel> findByModelYearBetween(int lowLimit, int highLimit);

  List<ArticleModel> findByMileageGreaterThan(int mileage);

  List<ArticleModel> findByMileageLessThan(int mileage);

  List<ArticleModel> findByMileageBetween(int lowLimit, int highLimit);

  List<ArticleModel> findByPublicationDateGreaterThan(int publicatioNDate);

  List<ArticleModel> findByPublicationDateLessThan(int publicationDate);

  List<ArticleModel> findByPublicationDateBetween(int lowLimit, int highLimit);

  List<ArticleModel> findByCylindricalCapacityGreaterThan(int cylindricalCapacity);

  List<ArticleModel> findByCylindricalCapacityLessThan(int cylindricalCapacity);

  List<ArticleModel> findByCylindricalCapacityBetween(int lowLimit, int highLimit);

}