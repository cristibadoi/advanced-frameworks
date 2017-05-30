package com.cristibadoi.automarket.logic.services;

import com.cristibadoi.automarket.persistence.models.*;
import com.cristibadoi.automarket.persistence.repositories.*;
import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelExtractorServiceImpl implements ModelExtractorService {

  @Autowired
  BrandRepository brandRepository;

  @Autowired
  ModelRepository modelRepository;

  @Autowired
  FuelRepository fuelRepository;

  @Autowired
  CityRepository cityRepository;

  @Autowired
  TypeRepository typeRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  StatusRepository statusRepository;

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

  @Override
  public List<TypeModel> getAllTypes() {
    return Lists.newArrayList(typeRepository.findAll());
  }

  @Override
  public List<StatusModel> getAllStatuses() {
    return Lists.newArrayList(statusRepository.findAll());
  }

  @Override
  public BrandModel findBrandByName(String name) {
    return brandRepository.findByName(name);
  }

  @Override
  public ModelModel findModelByName(String name) {
    return modelRepository.findByName(name);
  }

  @Override
  public FuelModel findFuelByName(String name) {
    return fuelRepository.findByName(name);
  }

  @Override
  public CityModel findCityByName(String name) {
    return cityRepository.findByName(name);
  }

  @Override
  public TypeModel findTypeByName(String name) {
    return typeRepository.findByName(name);
  }

  @Override
  public StatusModel findStatusByName(String name) {
    return statusRepository.findByName(name);
  }

}
