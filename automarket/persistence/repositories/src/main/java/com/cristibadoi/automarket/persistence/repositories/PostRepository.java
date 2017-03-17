package com.cristibadoi.automarket.persistence.repositories;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.BrandModel;
import com.cristibadoi.automarket.persistence.models.CityModel;
import com.cristibadoi.automarket.persistence.models.CurrencyModel;
import com.cristibadoi.automarket.persistence.models.FuelModel;
import com.cristibadoi.automarket.persistence.models.ModelModel;
import com.cristibadoi.automarket.persistence.models.PostModel;
import com.cristibadoi.automarket.persistence.models.StatusModel;
import com.cristibadoi.automarket.persistence.models.UserModel;

public interface PostRepository extends CrudRepository<PostModel, Long>, QueryDslPredicateExecutor<PostModel> {

  List<PostModel> findByUser(UserModel user);

  List<PostModel> findByModel(ModelModel model);

  List<PostModel> findByBrand(BrandModel brand);

  List<PostModel> findByCity(CityModel city);

  List<PostModel> findByStatus(StatusModel status);

  List<PostModel> findByCurrency(CurrencyModel currency);

  List<PostModel> findByFuel(FuelModel fuel);

  List<PostModel> findByModelYearGreaterThan(int modelYear);

  List<PostModel> findByModelYearLessThan(int modelYear);

  List<PostModel> findByModelYearBetween(int lowLimit, int highLimit);

  List<PostModel> findByMileageGreaterThan(int mileage);

  List<PostModel> findByMileageLessThan(int mileage);

  List<PostModel> findByMileageBetween(int lowLimit, int highLimit);

  List<PostModel> findByPublicationDateGreaterThan(int publicatioNDate);

  List<PostModel> findByPublicationDateLessThan(int publicationDate);

  List<PostModel> findByPublicationDateBetween(int lowLimit, int highLimit);

  List<PostModel> findByCylindricalCapacityGreaterThan(int cylindricalCapacity);

  List<PostModel> findByCylindricalCapacityLessThan(int cylindricalCapacity);

  List<PostModel> findByCylindricalCapacityBetween(int lowLimit, int highLimit);

}