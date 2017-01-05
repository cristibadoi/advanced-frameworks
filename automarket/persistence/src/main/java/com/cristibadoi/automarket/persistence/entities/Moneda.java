package com.cristibadoi.automarket.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Moneda {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String cod;
  private long idTara;

  Moneda() {
  }

  public Moneda(long id, String cod, long idTara) {
    this.id = id;
    this.cod = cod;
    this.idTara = idTara;
  }

  @Override
  public String toString() {
    return "Moneda [id=" + id + ", cod=" + cod + ", idTara=" + idTara + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cod == null) ? 0 : cod.hashCode());
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
    Moneda other = (Moneda) obj;
    if (cod == null) {
      if (other.cod != null)
        return false;
    } else if (!cod.equals(other.cod))
      return false;
    return true;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCod() {
    return cod;
  }

  public void setCod(String cod) {
    this.cod = cod;
  }

  public long getIdTara() {
    return idTara;
  }

  public void setIdTara(long idTara) {
    this.idTara = idTara;
  }

}
