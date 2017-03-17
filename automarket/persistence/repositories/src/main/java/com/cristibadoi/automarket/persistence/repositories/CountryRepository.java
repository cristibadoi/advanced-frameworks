package com.cristibadoi.automarket.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.CountryModel;
import com.cristibadoi.automarket.persistence.models.CurrencyModel;

public interface CountryRepository extends CrudRepository<CountryModel, Long> {

  CountryModel findByName(String name);

  List<CountryModel> findByCurrency(CurrencyModel currency);

}