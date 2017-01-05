package com.cristibadoi.automarket.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tara {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String nume;

  Tara() {
  }

  public Tara(long id, String nume) {
    this.id = id;
    this.nume = nume;
  }

  @Override
  public String toString() {
    return "Tara [id=" + id + ", nume=" + nume + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
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
    Tara other = (Tara) obj;
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

  public String getNume() {
    return nume;
  }

  public void setNume(String nume) {
    this.nume = nume;
  }

}
