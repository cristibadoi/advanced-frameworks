package com.cristibadoi.automarket.logic.services;

import com.cristibadoi.automarket.logic.constants.ServiceLayerConstants;
import com.cristibadoi.automarket.logic.exceptions.EmailSendingFailureException;
import com.cristibadoi.automarket.logic.exceptions.InvalidActivationCode;
import com.cristibadoi.automarket.logic.generators.ActivationCodeGenerator;
import com.cristibadoi.automarket.persistence.models.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class AccountActivationServiceImpl implements AccountActivationService {

  @Autowired
  private UserService userService;

  @Autowired
  private ActivationCodeGenerator activationCodeGenerator;

  @Override
  public void sendConfirmationEmail(UserModel user) throws EmailSendingFailureException {

    Properties properties = new Properties();
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.host", ServiceLayerConstants.EMAIL_HOST);
    properties.put("mail.smtp.port", "587");
    Session session = Session.getInstance(properties, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(ServiceLayerConstants.HOST_CONNECTION_EMAIL,
                                          ServiceLayerConstants.HOST_CONNECTION_PASSWORD);
      }
    });

    try {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(ServiceLayerConstants.EMAIL_FROM));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
      message.setSubject(ServiceLayerConstants.EMAIL_CONFIRMATION_SUBJECT);

      StringBuilder messageText = new StringBuilder();
      messageText.append("Hello, ").append(user.getUsername()).append("!\n\n");
      messageText.append("Please click the link below to activate your Automarket account:\n\n");
      messageText.append(ServiceLayerConstants.CONFIRMATION_LINK_BASE).append(user.getId()).append("/")
          .append(user.getConfirmationCode());
      message.setText(messageText.toString());

      Transport.send(message);
      //TODO log message expedition successful
    } catch (MessagingException e) {
      //TODO log exception
      throw new EmailSendingFailureException(ServiceLayerConstants.EMAIL_SENDING_FAILURE_MESSAGE);
    }

  }

  @Override
  public void activateAccount(long accountId, String activationCode) throws InvalidActivationCode {

    UserModel user = userService.getUserById(accountId);

    if (!user.getConfirmationCode().equals(activationCode)) {
      throw new InvalidActivationCode(ServiceLayerConstants.INVALID_ACTIVATION_CODE_MESSAGE);
    }

    user.setEnabled(true);
    user.setConfirmationCode(activationCodeGenerator.generateActivationCode());
    userService.saveUser(user);

  }

}
