package com.cristibadoi.automarket.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.Utilizator;

public interface UtilizatorRepository extends CrudRepository<Utilizator, Long> {

  public Utilizator findByEmail(String email);

}