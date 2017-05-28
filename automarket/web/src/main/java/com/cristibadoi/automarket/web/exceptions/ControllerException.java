package com.cristibadoi.automarket.web.exceptions;

import com.cristibadoi.automarket.global.exceptions.ApplicationException;

public class ControllerException extends ApplicationException {

  private static final long serialVersionUID = -3488290876497820132L;

  public ControllerException(String message) {
    super(message);
  }

}
