package com.cristibadoi.automarket.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.FuelModel;

public interface CombustibilRepository extends CrudRepository<FuelModel, Long> {

  public FuelModel findByName(String name);

}