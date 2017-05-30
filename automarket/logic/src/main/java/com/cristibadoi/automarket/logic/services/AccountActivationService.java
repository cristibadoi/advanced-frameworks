package com.cristibadoi.automarket.logic.services;

import com.cristibadoi.automarket.persistence.models.UserModel;

public interface AccountActivationService {

  void sendConfirmationEmail(UserModel user);

  void activateAccount(long accountId, String activationCode);

}
