package com.cristibadoi.automarket.logic.validators;

import com.cristibadoi.automarket.global.constants.GlobalConstants;
import com.cristibadoi.automarket.logic.input.PublishInput;
import com.cristibadoi.automarket.logic.services.ModelExtractorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

@Component
public class PublishInputValidator implements Validator {

  private static final String MISSING_BRAND = "Brand not specified!";
  private static final String INVALID_BRAND = "Invalid brand!";
  private static final String MISSING_MODEL = "Model not specified!";
  private static final String INVALID_MODEL = "Invalid model!";
  private static final String MISSING_TYPE = "Body type not specified!";
  private static final String INVALID_TYPE = "Missing body type!";
  private static final String MISSING_FUEL = "Fuel not specified!";
  private static final String INVALID_FUEL = "Invalid fuel!";
  private static final int MINIMUM_CAR_YEAR = 1808; //the invention of the automobile
  private static final String MISSING_YEAR = "Year not specified!";
  private static final String INVALID_YEAR = "Invalid year!";
  private static final String MISSING_CAPACITY = "Missing capacity!";
  private static final String INVALID_CAPACITY = "Invalid capacity!";
  private static final String MISSING_MILEAGE = "Mileage not specified!";
  private static final String INVALID_MILEAGE = "Invalid mileage!";
  private static final String MISSING_DESCRIPTION = "No description provided!";
  private static final String MISSING_PRICE = "Price not specified!";
  private static final String INVALID_PRICE = "Invalid price!";
  private static final String MISSING_CITY = "City not specified!";
  private static final String INVALID_CITY = "Invalid city!";
  private static final String MISSING_PHONE = "Phone number not specified!";
  private static final String INVALID_PHONE = "Invalid phone number!";
  private static final String PHONE_REGEX = "\\d+";
  private static final String MISSING_EMAIL = "E-mail address not specified!";
  private static final String INVALID_EMAIL = "Invalid e-mail address!";
  private static final String MISSING_IMAGES = "No images provided!";
  private static final String INVALID_IMAGES = "Invalid image files!";

  @Autowired
  ModelExtractorService modelExtractorService;

  @Override
  public boolean supports(Class<?> aClass) {
    return PublishInput.class.equals(aClass);
  }

  @Override
  public void validate(Object target, Errors errors) {

    PublishInput publishInput = (PublishInput) target;

    if (publishInput.getBrand() == null) {
      errors.rejectValue("brand", MISSING_BRAND);
    } else if (modelExtractorService.findBrandByName(publishInput.getBrand()) == null) {
      errors.rejectValue("brand", INVALID_BRAND);
    }

    if (publishInput.getModel() == null) {
      errors.rejectValue("model", MISSING_MODEL);
    } else if (modelExtractorService.findModelByName(publishInput.getModel()) == null) {
      errors.rejectValue("model", INVALID_MODEL);
    }

    if (publishInput.getType() == null) {
      errors.rejectValue("type", MISSING_TYPE);
    } else if (modelExtractorService.findTypeByName(publishInput.getType()) == null) {
      errors.rejectValue("type", INVALID_TYPE);
    }

    if (publishInput.getFuel() == null) {
      errors.rejectValue("fuel", MISSING_FUEL);
    } else if (modelExtractorService.findFuelByName(publishInput.getFuel()) == null) {
      errors.rejectValue("fuel", INVALID_FUEL);
    }

    if (publishInput.getYear() == null) {
      errors.rejectValue("year", MISSING_YEAR);
    } else if (publishInput.getYear() < MINIMUM_CAR_YEAR) {
      errors.rejectValue("year", INVALID_YEAR);
    }

    if (publishInput.getCapacity() == null) {
      errors.rejectValue("capacity", MISSING_CAPACITY);
    } else if (publishInput.getCapacity() <= 0) {
      errors.rejectValue("capacity", INVALID_CAPACITY);
    }

    if (publishInput.getMileage() == null) {
      errors.rejectValue("mileage", MISSING_MILEAGE);
    } else if (publishInput.getMileage() <= 0) {
      errors.rejectValue("mileage", INVALID_MILEAGE);
    }

    if (publishInput.getDescription() == null) {
      errors.rejectValue("description", MISSING_DESCRIPTION);
    }

    if (publishInput.getPrice() == null) {
      errors.rejectValue("price", MISSING_PRICE);
    } else if (publishInput.getPrice() <= 0) {
      errors.rejectValue("price", INVALID_PRICE);
    }

    if (publishInput.getCity() == null) {
      errors.rejectValue("city", MISSING_CITY);
    } else if (modelExtractorService.findCityByName(publishInput.getCity()) == null) {
      errors.rejectValue("city", INVALID_CITY);
    }

    if (publishInput.getPhone() == null) {
      errors.rejectValue("phone", MISSING_PHONE);
    } else if (!validatePhone(publishInput.getPhone())) {
      errors.rejectValue("phone", INVALID_PHONE);
    }

    if (publishInput.getEmail() == null) {
      errors.rejectValue("email", MISSING_EMAIL);
    } else if (!validateEmail(publishInput.getEmail())) {
      errors.rejectValue("email", INVALID_EMAIL);
    }

    if (publishInput.getImages() == null) {
      errors.rejectValue("images", MISSING_IMAGES);
    } else {
      if (publishInput.getImages().length == 0) {
        errors.rejectValue("images", MISSING_IMAGES);
      }
      if (!validateImageExtensions(publishInput.getImages())) {
        errors.rejectValue("images", INVALID_IMAGES);
      }
    }

  }

  private boolean validatePhone(String phone) {
    return phone.substring(1).matches(PHONE_REGEX);
  }

  private boolean validateEmail(String email) {
    return GlobalConstants.EMAIL_REGEX.matcher(email).matches();
  }

  private boolean validateImageExtensions(MultipartFile[] images) {
    boolean result = false;
    for (MultipartFile image : images) {
      try {
        String[] parts = image.getOriginalFilename().split("\\.");
        String imageExtension = parts[1];
        if (imageExtension.equals("jpeg") || imageExtension.equals("jpg") || imageExtension.equals("png")) {
          result = true;
        }
      } catch (IndexOutOfBoundsException e) {
        return false;
      }

    }
    return result;
  }

}
