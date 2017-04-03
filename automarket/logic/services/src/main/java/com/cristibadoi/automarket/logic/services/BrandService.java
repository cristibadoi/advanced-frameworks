package com.cristibadoi.automarket.logic.services;

import com.cristibadoi.automarket.persistence.models.BrandModel;

public interface BrandService {

  BrandModel findByName(String name);
  
}
