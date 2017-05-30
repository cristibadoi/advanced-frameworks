package com.cristibadoi.automarket.logic.exceptions;

public class EmailSendingFailureException extends ServiceException {

  private static final long serialVersionUID = 2215226130945392730L;

  public EmailSendingFailureException(String message) {
    super(message);
  }

}
