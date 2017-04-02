package com.cristibadoi.automarket.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.BrandModel;

public interface BrandRepository extends CrudRepository<BrandModel, Long> {

  BrandModel findByName(String name);

}