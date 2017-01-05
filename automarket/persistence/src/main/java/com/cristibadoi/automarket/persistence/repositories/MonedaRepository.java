package com.cristibadoi.automarket.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.entities.Moneda;

public interface MonedaRepository extends CrudRepository<Moneda, Long> {

  public Moneda findByCod(String cod);

}
