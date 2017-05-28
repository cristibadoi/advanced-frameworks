package com.cristibadoi.automarket.logic.exceptions;

public class ArticleNotFoundException extends ServiceException {
  
  private static final long serialVersionUID = 4423855715097156404L;

  public ArticleNotFoundException(String message) {
    super(message);
  }

}
