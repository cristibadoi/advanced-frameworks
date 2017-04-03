package com.cristibadoi.automarket.logic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristibadoi.automarket.persistence.models.BrandModel;
import com.cristibadoi.automarket.persistence.repositories.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {

  @Autowired
  BrandRepository brandRepository;

  @Override
  public BrandModel findByName(String name) {
    
    return brandRepository.findByName(name);
    
  }

}
