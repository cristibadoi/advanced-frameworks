package com.cristibadoi.automarket.logic.validators;

import com.cristibadoi.automarket.logic.constants.ServiceLayerConstants;
import com.cristibadoi.automarket.logic.services.UserService;
import com.cristibadoi.automarket.persistence.models.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

  private static final String MISSING_USERNAME = "Username not specified!";
  private static final String INVALID_USERNAME = "Invalid username!";
  private static final String MISSING_PASSWORD = "Password not provided";
  private static final String INVALID_PASSWORD = "Invalid password!";
  private static final String MISSING_EMAIL = "E-mail address not specified!";
  private static final String INVALID_EMAIL = "Invalid e-mail address!";
  private static final String USERNAME_UNAVAILABLE = "Username unavailable!";
  private static final String EMAIL_ALREADY_REGISTERED = "E-mail address is already registered!";

  @Autowired
  UserService userService;

  @Override
  public boolean supports(Class<?> aClass) {
    return UserModel.class.equals(aClass);
  }

  @Override
  public void validate(Object target, Errors errors) {
    UserModel user = (UserModel) target;

    if (user.getUsername() == null) {
      errors.rejectValue("username", MISSING_USERNAME);
    } else if (user.getUsername().length() < 5 || user.getUsername().length() > 15) {
      errors.rejectValue("username", INVALID_USERNAME);
    } else if (userService.getUserByUsername(user.getUsername()) != null) {
      errors.rejectValue("username", USERNAME_UNAVAILABLE);
    }

    if (user.getPassword() == null) {
      errors.rejectValue("password", MISSING_PASSWORD);
    } else if (user.getPassword().length() < 10 || user.getPassword().length() > 20) {
      errors.rejectValue("password", INVALID_PASSWORD);
    }

    if (user.getEmail() == null) {
      errors.rejectValue("email", MISSING_EMAIL);
    } else if (!validateEmail(user.getEmail())) {
      errors.rejectValue("email", INVALID_EMAIL);
    } else if (userService.getUserByEmail(user.getEmail()) != null) {
      errors.rejectValue("email", EMAIL_ALREADY_REGISTERED);
    }

  }

  private boolean validateEmail(String email) {
    return ServiceLayerConstants.EMAIL_REGEX.matcher(email).matches();
  }

}
