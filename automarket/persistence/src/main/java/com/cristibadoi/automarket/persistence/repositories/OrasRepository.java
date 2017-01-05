package com.cristibadoi.automarket.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.entities.Oras;

public interface OrasRepository extends CrudRepository<Oras, Long> {

  public Oras findByNume(String nume);

}
