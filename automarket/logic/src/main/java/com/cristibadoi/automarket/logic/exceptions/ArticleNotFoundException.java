package com.cristibadoi.automarket.logic.exceptions;

public class ArticleNotFoundException extends ServiceException {

  private static final long serialVersionUID = 2791654293557832280L;

  public ArticleNotFoundException(String message) {
    super(message);
  }

}
