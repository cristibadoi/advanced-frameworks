package com.cristibadoi.automarket.logic.services;

import com.cristibadoi.automarket.persistence.models.UserModel;

public interface UserService {

  void save(UserModel user);
  
  UserModel findByUsername(String username);
  
}
