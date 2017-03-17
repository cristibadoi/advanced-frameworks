package com.cristibadoi.automarket.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.BrandModel;
import com.cristibadoi.automarket.persistence.models.CountryModel;

public interface BrandRepository extends CrudRepository<BrandModel, Long> {

  BrandModel findByName(String name);

  List<BrandModel> findByCountry(CountryModel country);

}