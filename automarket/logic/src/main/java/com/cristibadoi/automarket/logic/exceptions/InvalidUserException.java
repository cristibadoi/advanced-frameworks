package com.cristibadoi.automarket.logic.exceptions;

import com.cristibadoi.automarket.global.exceptions.ApplicationException;

public class InvalidUserException extends ApplicationException {

  private static final long serialVersionUID = 9017516508202840624L;

  public InvalidUserException(String message) {
    super(message);
  }

}
