package com.cristibadoi.automarket.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Long> {

  UserModel findByEmail(String email);

  UserModel findByUsername(String username);

  UserModel findById(long id);

}