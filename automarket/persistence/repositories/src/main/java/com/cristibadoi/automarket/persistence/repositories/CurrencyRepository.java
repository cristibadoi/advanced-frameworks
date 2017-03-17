package com.cristibadoi.automarket.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.CurrencyModel;

public interface CurrencyRepository extends CrudRepository<CurrencyModel, Long> {

  CurrencyModel findByCode(String code);

}