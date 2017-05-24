package com.cristibadoi.automarket.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.RoleModel;

public interface RoleRepository extends CrudRepository<RoleModel, Long> {

  RoleModel findByName(String name);

}