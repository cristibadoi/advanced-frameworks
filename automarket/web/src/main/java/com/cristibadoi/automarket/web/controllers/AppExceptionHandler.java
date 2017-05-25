package com.cristibadoi.automarket.web.controllers;

import com.cristibadoi.automarket.global.exceptions.ApplicationException;
import com.cristibadoi.automarket.web.constants.WebLayerConstants;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AppExceptionHandler {

  @ExceptionHandler(ApplicationException.class)
  public ModelAndView handleAllApplicationExceptions(Exception ex) {

    ModelAndView model = new ModelAndView("error");
    model.addObject("message", ex.getMessage());

    return model;

  }

  /*
  @ExceptionHandler(Exception.class)
  public ModelAndView handleAllExceptions(Exception ex) {

    //TO DO log exception stack trace

    ModelAndView model = new ModelAndView("error");
    model.addObject("message", WebLayerConstants.GENERIC_ERROR_MESSAGE);

    return model;

  }
  */

}
