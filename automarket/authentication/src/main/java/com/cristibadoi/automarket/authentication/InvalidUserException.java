package com.cristibadoi.automarket.authentication;

import com.cristibadoi.automarket.global.exceptions.ApplicationException;

public class InvalidUserException extends ApplicationException {

  public InvalidUserException(String message) {
    super(message);
  }

}
