package com.cristibadoi.automarket.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.TypeModel;

public interface TypeRepository extends CrudRepository<TypeModel, Long> {

  TypeModel findByName(String name);

}