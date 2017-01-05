package com.cristibadoi.automarket.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.entities.Vanzare;

public interface VanzareRepository extends CrudRepository<Vanzare, Long> {

  public List<Vanzare> findByIdUtilizator(long idUtilizator);

  public List<Vanzare> findByIdModel(long idModel);

  public List<Vanzare> findByIdMarca(long idMarca);

  public List<Vanzare> findByAnFabricatieGreaterThan(int anFabricatie);

  public List<Vanzare> findByAnFabricatieLessThan(int anFabricatie);

  public List<Vanzare> findByKilometrajGreaterThan(int kilometraj);

  public List<Vanzare> findByKilometrajLessThan(int kilometraj);

  public List<Vanzare> findByDataPublicareBetween(int lowLimit, int highLimit);

  public List<Vanzare> findByIdOras(long idOras);

  public List<Vanzare> findByStatus(String status);

}