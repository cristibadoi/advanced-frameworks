package com.cristibadoi.automarket.web.controllers;

import com.cristibadoi.automarket.logic.exceptions.InvalidActivationCode;
import com.cristibadoi.automarket.logic.services.AccountActivationService;
import com.cristibadoi.automarket.web.constants.WebLayerConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/activation/")
public class ActivationController {

  @Autowired
  private AccountActivationService accountActivationService;

  @GetMapping("/{accountId}/{activationCode}")
  public ModelAndView confirmEmail(@PathVariable("accountId") long accountId,
                                   @PathVariable("activationCode") String activationCode)
      throws InvalidActivationCode {

    accountActivationService.activateAccount(accountId, activationCode);

    ModelAndView model = new ModelAndView("success");
    model.addObject("message", WebLayerConstants.ACCOUNT_ACTIVATION_SUCCESS_MESSAGE);
    return model;

  }

}
