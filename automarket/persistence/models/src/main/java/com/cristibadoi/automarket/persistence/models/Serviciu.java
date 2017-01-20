package com.cristibadoi.automarket.persistence.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Serviciu {
  
  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long id;
  private long idUtilizator;
  private String titlu;
  private String descriere;
  private String telefon;
  private String email;
  private long idOras;
  private String adresa;
  private String imagini;
  private int dataPublicare;
  private String status;
  
  Serviciu() {}

  public Serviciu(long id, long idUtilizator, String titlu, String descriere, String telefon, String email, long idOras,
      String adresa, String imagini, int dataPublicare, String status) {
    this.id = id;
    this.idUtilizator = idUtilizator;
    this.titlu = titlu;
    this.descriere = descriere;
    this.telefon = telefon;
    this.email = email;
    this.idOras = idOras;
    this.adresa = adresa;
    this.imagini = imagini;
    this.dataPublicare = dataPublicare;
    this.status = status;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Serviciu [id=");
    builder.append(id);
    builder.append(", idUtilizator=");
    builder.append(idUtilizator);
    builder.append(", titlu=");
    builder.append(titlu);
    builder.append(", descriere=");
    builder.append(descriere);
    builder.append(", telefon=");
    builder.append(telefon);
    builder.append(", email=");
    builder.append(email);
    builder.append(", idOras=");
    builder.append(idOras);
    builder.append(", adresa=");
    builder.append(adresa);
    builder.append(", imagini=");
    builder.append(imagini);
    builder.append(", dataPublicare=");
    builder.append(dataPublicare);
    builder.append(", status=");
    builder.append(status);
    builder.append("]");
    return builder.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
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
    Serviciu other = (Serviciu) obj;
    if (id != other.id)
      return false;
    return true;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getIdUtilizator() {
    return idUtilizator;
  }

  public void setIdUtilizator(long idUtilizator) {
    this.idUtilizator = idUtilizator;
  }

  public String getTitlu() {
    return titlu;
  }

  public void setTitlu(String titlu) {
    this.titlu = titlu;
  }

  public String getDescriere() {
    return descriere;
  }

  public void setDescriere(String descriere) {
    this.descriere = descriere;
  }

  public String getTelefon() {
    return telefon;
  }

  public void setTelefon(String telefon) {
    this.telefon = telefon;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public long getIdOras() {
    return idOras;
  }

  public void setIdOras(long idOras) {
    this.idOras = idOras;
  }

  public String getAdresa() {
    return adresa;
  }

  public void setAdresa(String adresa) {
    this.adresa = adresa;
  }

  public String getImagini() {
    return imagini;
  }

  public void setImagini(String imagini) {
    this.imagini = imagini;
  }

  public int getDataPublicare() {
    return dataPublicare;
  }

  public void setDataPublicare(int dataPublicare) {
    this.dataPublicare = dataPublicare;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
  
}
