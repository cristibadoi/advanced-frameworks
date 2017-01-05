package com.cristibadoi.automarket.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Model {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String nume;
  private long idMarca;
  
  Model() {}

  public Model(long id, String nume, long idMarca) {
    this.id = id;
    this.nume = nume;
    this.idMarca = idMarca;
  }

  @Override
  public String toString() {
    return "Model [id=" + id + ", nume=" + nume + ", idMarca=" + idMarca + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (idMarca ^ (idMarca >>> 32));
    result = prime * result + ((nume == null) ? 0 : nume.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Model other = (Model) obj;
    if (idMarca != other.idMarca)
      return false;
    if (nume == null) {
      if (other.nume != null)
        return false;
    } else if (!nume.equals(other.nume))
      return false;
    return true;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getnume() {
    return nume;
  }

  public void setnume(String nume) {
    this.nume = nume;
  }

  public long getIdMarca() {
    return idMarca;
  }

  public void setIdMarca(long idMarca) {
    this.idMarca = idMarca;
  }
  
}