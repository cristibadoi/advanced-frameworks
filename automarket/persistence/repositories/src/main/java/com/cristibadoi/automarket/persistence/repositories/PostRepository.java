package com.cristibadoi.automarket.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.BrandModel;
import com.cristibadoi.automarket.persistence.models.CityModel;
import com.cristibadoi.automarket.persistence.models.CurrencyModel;
import com.cristibadoi.automarket.persistence.models.FuelModel;
import com.cristibadoi.automarket.persistence.models.ModelModel;
import com.cristibadoi.automarket.persistence.models.PostModel;
import com.cristibadoi.automarket.persistence.models.StatusModel;
import com.cristibadoi.automarket.persistence.models.UserModel;

public interface PostRepository extends CrudRepository<PostModel, Long> {

  public List<PostModel> findByUser(UserModel user);

  public List<PostModel> findByModel(ModelModel model);

  public List<PostModel> findByBrand(BrandModel brand);

  public List<PostModel> findByCity(CityModel city);

  public List<PostModel> findByStatus(StatusModel status);

  public List<PostModel> findByCurrency(CurrencyModel currency);

  public List<PostModel> findByFuel(FuelModel fuel);

  public List<PostModel> findByModelYearGreaterThan(int modelYear);

  public List<PostModel> findByModelYearLessThan(int modelYear);

  public List<PostModel> findByModelYearBetween(int lowLimit, int highLimit);

  public List<PostModel> findByMileageGreaterThan(int mileage);

  public List<PostModel> findByMileageLessThan(int mileage);

  public List<PostModel> findByMileageBetween(int lowLimit, int highLimit);

  public List<PostModel> findByPublicationDateGreaterThan(int publicatioNDate);

  public List<PostModel> findByPublicationDateLessThan(int publicationDate);

  public List<PostModel> findByPublicationDateBetween(int lowLimit, int highLimit);

  public List<PostModel> findByCylindricalCapacityGreaterThan(int cylindricalCapacity);

  public List<PostModel> findByCylindricalCapacityLessThan(int cylindricalCapacity);

  public List<PostModel> findByCylindricalCapacityBetween(int lowLimit, int highLimit);

}