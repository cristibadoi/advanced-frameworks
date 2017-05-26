package com.cristibadoi.automarket.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.CityModel;

public interface CityRepository extends CrudRepository<CityModel, Long> {

  CityModel findByName(String name);

}