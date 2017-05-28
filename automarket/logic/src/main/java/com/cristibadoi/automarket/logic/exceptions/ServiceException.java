package com.cristibadoi.automarket.logic.exceptions;

import com.cristibadoi.automarket.global.exceptions.ApplicationException;

public class ServiceException extends ApplicationException {

  private static final long serialVersionUID = 1055931920761738893L;

  public ServiceException(String message) {
    super(message);
  }

}
