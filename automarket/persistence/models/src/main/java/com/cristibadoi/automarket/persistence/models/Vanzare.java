package com.cristibadoi.automarket.persistence.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vanzare {

  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long id;
  private long idUtilizator;
  private long idMarca;
  private long idModel;
  private int anFabricatie;
  private int kilometraj;
  private long idCombustibil;
  private int pret;
  private long idMoneda;
  private String telefon;
  private String email;
  private String descriere;
  private long idOras;
  private String imagini;
  private int dataPublicare;
  private String status;
  
  Vanzare() {}

  public Vanzare(long id, long idUtilizator, long idMarca, long idModel, int anFabricatie, int kilometraj,
      long idCombustibil, int pret, long idMoneda, String telefon, String email, String descriere, long idOras,
      String imagini, int dataPublicare, String status) {
    this.id = id;
    this.idUtilizator = idUtilizator;
    this.idMarca = idMarca;
    this.idModel = idModel;
    this.anFabricatie = anFabricatie;
    this.kilometraj = kilometraj;
    this.idCombustibil = idCombustibil;
    this.pret = pret;
    this.idMoneda = idMoneda;
    this.telefon = telefon;
    this.email = email;
    this.descriere = descriere;
    this.idOras = idOras;
    this.imagini = imagini;
    this.dataPublicare = dataPublicare;
    this.status = status;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Vanzare [id=");
    builder.append(id);
    builder.append(", idUtilizator=");
    builder.append(idUtilizator);
    builder.append(", idMarca=");
    builder.append(idMarca);
    builder.append(", idModel=");
    builder.append(idModel);
    builder.append(", anFabricatie=");
    builder.append(anFabricatie);
    builder.append(", kilometraj=");
    builder.append(kilometraj);
    builder.append(", idCombustibil=");
    builder.append(idCombustibil);
    builder.append(", pret=");
    builder.append(pret);
    builder.append(", idMoneda=");
    builder.append(idMoneda);
    builder.append(", telefon=");
    builder.append(telefon);
    builder.append(", email=");
    builder.append(email);
    builder.append(", descriere=");
    builder.append(descriere);
    builder.append(", idOras=");
    builder.append(idOras);
    builder.append(", imagini=");
    builder.append(imagini);
    builder.append(", dataPublicare=");
    builder.append(dataPublicare);
    builder.append(", status=");
    builder.append(status);
    builder.append(", getClass()=");
    builder.append(getClass());
    builder.append(", hashCode()=");
    builder.append(hashCode());
    builder.append(", toString()=");
    builder.append(super.toString());
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
    Vanzare other = (Vanzare) obj;
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

  public long getIdMarca() {
    return idMarca;
  }

  public void setIdMarca(long idMarca) {
    this.idMarca = idMarca;
  }

  public long getIdModel() {
    return idModel;
  }

  public void setIdModel(long idModel) {
    this.idModel = idModel;
  }

  public int getAnFabricatie() {
    return anFabricatie;
  }

  public void setAnFabricatie(int anFabricatie) {
    this.anFabricatie = anFabricatie;
  }

  public int getKilometraj() {
    return kilometraj;
  }

  public void setKilometraj(int kilometraj) {
    this.kilometraj = kilometraj;
  }

  public long getIdCombustibil() {
    return idCombustibil;
  }

  public void setIdCombustibil(long idCombustibil) {
    this.idCombustibil = idCombustibil;
  }

  public int getPret() {
    return pret;
  }

  public void setPret(int pret) {
    this.pret = pret;
  }

  public long getIdMoneda() {
    return idMoneda;
  }

  public void setIdMoneda(long idMoneda) {
    this.idMoneda = idMoneda;
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

  public String getDescriere() {
    return descriere;
  }

  public void setDescriere(String descriere) {
    this.descriere = descriere;
  }

  public long getIdOras() {
    return idOras;
  }

  public void setIdOras(long idOras) {
    this.idOras = idOras;
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
