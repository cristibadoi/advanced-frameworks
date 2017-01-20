package com.cristibadoi.automarket.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.Serviciu;

public interface ServiciuRepository extends CrudRepository<Serviciu, Long> {

  public List<Serviciu> findByIdUtilizator(long idUtilizator);
  
  public List<Serviciu> findByTitlu(String titlu);
  
  public List<Serviciu> findByDataPublicareBetween(int lowLimit, int highLimit);
  
  public List<Serviciu> findByIdOras(long idOras);
  
  public List<Serviciu> findByStatus(String status);
  
}
