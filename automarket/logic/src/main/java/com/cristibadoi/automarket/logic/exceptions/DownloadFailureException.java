package com.cristibadoi.automarket.logic.exceptions;

public class DownloadFailureException extends ServiceException {
  
  private static final long serialVersionUID = -8804772536217613327L;

  public DownloadFailureException(String message) {
    super(message);
  }

}
