package com.cristibadoi.automarket.logic.services;

import java.util.List;

import com.cristibadoi.automarket.persistence.models.BrandModel;
import com.cristibadoi.automarket.persistence.models.CityModel;
import com.cristibadoi.automarket.persistence.models.FuelModel;
import com.cristibadoi.automarket.persistence.models.ModelModel;
import com.cristibadoi.automarket.persistence.models.StatusModel;
import com.cristibadoi.automarket.persistence.models.TypeModel;
import com.cristibadoi.automarket.persistence.models.UserModel;

public interface ModelExtractorService {
  
  List<BrandModel> getAllBrands();
  
  List<ModelModel> getAllModels();
  
  List<FuelModel> getAllFuels();
  
  List<CityModel> getAllCities();

  List<TypeModel> getAllTypes();
  
  List<StatusModel> getAllStatuses();
  
  List<UserModel> getAllUsers();
  
  BrandModel findBrandByName(String name);
  
  ModelModel findModelByName(String name);
  
  FuelModel findFuelByName(String name);
  
  CityModel findCityByName(String name);
  
  TypeModel findTypeByName(String name);
  
  UserModel findUserByUsername(String username);
  
  StatusModel findStatusByName(String name);
  
}
