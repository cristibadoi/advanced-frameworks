package com.cristibadoi.automarket.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Long> {

  public UserModel findByEmail(String email);

}