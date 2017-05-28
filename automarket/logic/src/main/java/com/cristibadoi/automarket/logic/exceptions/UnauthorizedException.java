package com.cristibadoi.automarket.logic.exceptions;

public class UnauthorizedException extends ServiceException{
  
  private static final long serialVersionUID = -6502955316866511640L;

  public UnauthorizedException(String message) {
    super(message);
  }

}
