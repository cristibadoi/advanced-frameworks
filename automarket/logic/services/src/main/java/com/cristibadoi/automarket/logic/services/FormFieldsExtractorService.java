package com.cristibadoi.automarket.logic.services;

import java.util.List;

import com.cristibadoi.automarket.persistence.models.BrandModel;
import com.cristibadoi.automarket.persistence.models.CityModel;
import com.cristibadoi.automarket.persistence.models.FuelModel;
import com.cristibadoi.automarket.persistence.models.ModelModel;

public interface FormFieldsExtractorService {
  
  List<BrandModel> getAllBrands();
  
  List<ModelModel> getAllModels();
  
  List<FuelModel> getAllFuels();
  
  List<CityModel> getAllCities();
  
}
