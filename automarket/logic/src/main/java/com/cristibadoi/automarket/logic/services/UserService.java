package com.cristibadoi.automarket.logic.services;

import com.cristibadoi.automarket.logic.exceptions.EmailSendingFailureException;
import com.cristibadoi.automarket.persistence.models.UserModel;

public interface UserService {

  void registerUser(UserModel user) throws EmailSendingFailureException;

  void saveUser(UserModel user);

  UserModel getUserById(long id);

  UserModel getUserByUsername(String username);

  UserModel getUserByEmail(String email);

}
