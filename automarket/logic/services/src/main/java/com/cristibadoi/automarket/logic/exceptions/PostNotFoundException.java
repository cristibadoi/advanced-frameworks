package com.cristibadoi.automarket.logic.exceptions;

public class PostNotFoundException extends ServiceException {

  private static final long serialVersionUID = 2791654293557832280L;

  public PostNotFoundException(String message) {
    super(message);
  }

}
