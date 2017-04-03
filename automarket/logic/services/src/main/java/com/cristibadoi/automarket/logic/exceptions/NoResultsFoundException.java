package com.cristibadoi.automarket.logic.exceptions;

public class NoResultsFoundException extends ServiceException {

  private static final long serialVersionUID = -9214321380281397352L;

  public NoResultsFoundException(String message) {
    super(message);
  }

}
