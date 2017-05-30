package com.cristibadoi.automarket.logic.services;

import com.cristibadoi.automarket.logic.exceptions.EmailSendingFailureException;
import com.cristibadoi.automarket.logic.exceptions.InvalidActivationCode;
import com.cristibadoi.automarket.persistence.models.UserModel;

public interface AccountActivationService {

  void sendConfirmationEmail(UserModel user) throws EmailSendingFailureException;

  void activateAccount(long accountId, String activationCode) throws InvalidActivationCode;

}
