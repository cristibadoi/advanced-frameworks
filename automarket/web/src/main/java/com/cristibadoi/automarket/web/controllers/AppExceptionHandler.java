package com.cristibadoi.automarket.web.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.cristibadoi.automarket.exceptions.ApplicationException;
import com.cristibadoi.automarket.logic.exceptions.NoResultsFoundException;
import com.cristibadoi.automarket.logic.exceptions.PostNotFoundException;

@ControllerAdvice
public class AppExceptionHandler {

  @ExceptionHandler(NoResultsFoundException.class)
  public ModelAndView handleNoResultsFoundException(NoResultsFoundException ex) {

    ModelAndView model = new ModelAndView("error");
    model.addObject("message", ex.getMessage());

    return model;

  }

  @ExceptionHandler(PostNotFoundException.class)
  public ModelAndView handlePostNotFoundException(PostNotFoundException ex) {

    ModelAndView model = new ModelAndView("error");
    model.addObject("message", ex.getMessage());

    return model;

  }

  @ExceptionHandler(ApplicationException.class)
  public ModelAndView handleAllApplicationExceptions(Exception ex) {

    ModelAndView model = new ModelAndView("error");
    model.addObject("message", "We're sorry, an error has occured!");

    return model;

  }

}
