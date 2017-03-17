package com.cristibadoi.automarket.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cristibadoi.automarket.persistence.models.UserModel;
import com.cristibadoi.automarket.persistence.repositories.RoleRepository;
import com.cristibadoi.automarket.persistence.repositories.UserRepository;
import com.google.common.collect.Lists;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleRepository roleRepository;
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public void save(UserModel user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setRoles(Lists.newArrayList(roleRepository.findAll()));
    userRepository.save(user);
  }

  @Override
  public UserModel findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

}
