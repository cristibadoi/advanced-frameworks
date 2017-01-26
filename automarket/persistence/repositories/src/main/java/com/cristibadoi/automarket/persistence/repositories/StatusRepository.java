package com.cristibadoi.automarket.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.StatusModel;

public interface StatusRepository extends CrudRepository<StatusModel, Long> {

  public StatusModel findByName(String name);

}
