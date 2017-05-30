package com.cristibadoi.automarket.logic.generators;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ActivationCodeGeneratorImpl implements ActivationCodeGenerator {

  @Override
  public String generateActivationCode() {

    StringBuilder result = new StringBuilder();
    Random random = new Random();

    for (int i = 0; i < 31; i++) {
      result.append(random.nextInt(10));
    }

    return result.toString();

  }

}
