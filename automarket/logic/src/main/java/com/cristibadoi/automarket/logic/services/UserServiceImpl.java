package com.cristibadoi.automarket.logic.services;

import com.cristibadoi.automarket.logic.exceptions.EmailSendingFailureException;
import com.cristibadoi.automarket.logic.generators.ActivationCodeGenerator;
import com.cristibadoi.automarket.persistence.models.UserModel;
import com.cristibadoi.automarket.persistence.repositories.RoleRepository;
import com.cristibadoi.automarket.persistence.repositories.UserRepository;
import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private ActivationCodeGenerator activationCodeGenerator;

  @Autowired
  private AccountActivationService accountActivationService;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  @Transactional
  public void registerUser(UserModel user) throws EmailSendingFailureException {

    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setRoles(Lists.newArrayList(roleRepository.findByName("ROLE_USER")));
    user.setEnabled(false);
    user.setConfirmationCode(activationCodeGenerator.generateActivationCode());

    userRepository.save(user);

    accountActivationService.sendConfirmationEmail(user);

  }

  @Override
  public void saveUser(UserModel user) {
    userRepository.save(user);
  }

  @Override
  public UserModel getUserById(long id) {
    return userRepository.findById(id);
  }

  @Override
  public UserModel getUserByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  public UserModel getUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }

}
