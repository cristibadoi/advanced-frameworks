package com.cristibadoi.automarket.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.BrandModel;
import com.cristibadoi.automarket.persistence.models.ModelModel;
import com.cristibadoi.automarket.persistence.models.TypeModel;

public interface ModelRepository extends CrudRepository<ModelModel, Long> {

  public List<ModelModel> findByName(String name);

  public List<ModelModel> findByBrand(BrandModel brand);

  public List<ModelModel> findByType(TypeModel type);

}