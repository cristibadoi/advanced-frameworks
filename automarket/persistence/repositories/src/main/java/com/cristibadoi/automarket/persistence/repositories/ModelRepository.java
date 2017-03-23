package com.cristibadoi.automarket.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.BrandModel;
import com.cristibadoi.automarket.persistence.models.ModelModel;

public interface ModelRepository extends CrudRepository<ModelModel, Long> {

  List<ModelModel> findByName(String name);

  List<ModelModel> findByBrand(BrandModel brand);

}