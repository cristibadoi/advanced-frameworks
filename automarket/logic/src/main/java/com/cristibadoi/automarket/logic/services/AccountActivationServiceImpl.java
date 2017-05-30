package com.cristibadoi.automarket.logic.services;

import com.cristibadoi.automarket.persistence.models.UserModel;

import org.springframework.stereotype.Service;

@Service
public class AccountActivationServiceImpl implements AccountActivationService{

  @Override
  public void sendConfirmationEmail(UserModel user) {

  }

  @Override
  public void activateAccount(long accountId, String activationCode) {

  }

}
