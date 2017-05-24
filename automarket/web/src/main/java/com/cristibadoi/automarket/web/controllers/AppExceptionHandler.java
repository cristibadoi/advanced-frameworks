package com.cristibadoi.automarket.web.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.cristibadoi.automarket.exceptions.ApplicationException;
import com.cristibadoi.automarket.logic.exceptions.NoResultsFoundException;
import com.cristibadoi.automarket.logic.exceptions.ArticleNotFoundException;
import com.cristibadoi.automarket.logic.exceptions.UploadFailureException;
import com.cristibadoi.automarket.web.constants.WebLayerConstants;

@ControllerAdvice
public class AppExceptionHandler {

  @ExceptionHandler(UploadFailureException.class)
  public ModelAndView handleUploadFailureException(UploadFailureException ex) {

    ModelAndView model = new ModelAndView("error");
    model.addObject("message", ex.getMessage());

    return model;

  }

  @ExceptionHandler(NoResultsFoundException.class)
  public ModelAndView handleNoResultsFoundException(NoResultsFoundException ex) {

    ModelAndView model = new ModelAndView("error");
    model.addObject("message", ex.getMessage());

    return model;

  }

  @ExceptionHandler(ArticleNotFoundException.class)
  public ModelAndView handlePostNotFoundException(ArticleNotFoundException ex) {

    ModelAndView model = new ModelAndView("error");
    model.addObject("message", ex.getMessage());

    return model;

  }

  @ExceptionHandler(ApplicationException.class)
  public ModelAndView handleAllApplicationExceptions(Exception ex) {

    ModelAndView model = new ModelAndView("error");
    model.addObject("message", WebLayerConstants.GENERIC_ERROR_MESSAGE);

    return model;

  }

}
