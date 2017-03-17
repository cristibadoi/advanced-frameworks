package com.cristibadoi.automarket.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.CityModel;
import com.cristibadoi.automarket.persistence.models.CountryModel;

public interface CityRepository extends CrudRepository<CityModel, Long> {

  CityModel findByName(String name);

  List<CityModel> findByCountry(CountryModel country);

}