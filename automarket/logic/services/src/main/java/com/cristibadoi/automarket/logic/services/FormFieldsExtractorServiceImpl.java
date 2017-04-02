package com.cristibadoi.automarket.logic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristibadoi.automarket.persistence.models.BrandModel;
import com.cristibadoi.automarket.persistence.models.CityModel;
import com.cristibadoi.automarket.persistence.models.FuelModel;
import com.cristibadoi.automarket.persistence.models.ModelModel;
import com.cristibadoi.automarket.persistence.repositories.BrandRepository;
import com.cristibadoi.automarket.persistence.repositories.CityRepository;
import com.cristibadoi.automarket.persistence.repositories.FuelRepository;
import com.cristibadoi.automarket.persistence.repositories.ModelRepository;
import com.google.common.collect.Lists;

@Service
public class FormFieldsExtractorServiceImpl implements FormFieldsExtractorService{

  @Autowired
  BrandRepository brandRepository;
  
  @Autowired
  ModelRepository modelRepository;
  
  @Autowired
  FuelRepository fuelRepository;
  
  @Autowired
  CityRepository cityRepository;
  
  @Override
  public List<BrandModel> getAllBrands() {
    return Lists.newArrayList(brandRepository.findAll());
  }

  @Override
  public List<ModelModel> getAllModels() {
    return Lists.newArrayList(modelRepository.findAll());
  }

  @Override
  public List<FuelModel> getAllFuels() {
    return Lists.newArrayList(fuelRepository.findAll());
  }

  @Override
  public List<CityModel> getAllCities() {
    return Lists.newArrayList(cityRepository.findAll());
  }

}
