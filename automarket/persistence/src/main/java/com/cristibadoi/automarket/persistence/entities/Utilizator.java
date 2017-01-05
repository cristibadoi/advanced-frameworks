package com.cristibadoi.automarket.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilizator {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String email;
  private String parola;

  Utilizator() {
  }

  public Utilizator(String email, String parola) {
    this.email = email;
    this.parola = parola;
  }

  @Override
  public String toString() {
    return "Utilizator [id=" + id + ", email=" + email + ", parola=" + parola + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((email == null) ? 0 : email.hashCode());
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
    Utilizator other = (Utilizator) obj;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    return true;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getParola() {
    return parola;
  }

  public void setParola(String parola) {
    this.parola = parola;
  }

}
