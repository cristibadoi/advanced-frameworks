package com.cristibadoi.automarket.persistence.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class CountryModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(unique = true, nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "currency_id", referencedColumnName = "id", nullable = false)
  private CurrencyModel currency;

  @OneToMany(mappedBy = "country")
  private List<BrandModel> brands;

  @OneToMany(mappedBy = "country")
  private List<CityModel> cities;

  public CountryModel() {
  }

  public CountryModel(String name, CurrencyModel currency) {
    this.name = name;
    this.currency = currency;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CurrencyModel getCurrency() {
    return currency;
  }

  public void setCurrency(CurrencyModel currency) {
    this.currency = currency;
  }

  public List<BrandModel> getBrands() {
    return brands;
  }

  public void setBrands(List<BrandModel> brands) {
    this.brands = brands;
  }

  public List<CityModel> getCities() {
    return cities;
  }

  public void setCities(List<CityModel> cities) {
    this.cities = cities;
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
    CountryModel other = (CountryModel) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CountryModel [id=");
    builder.append(id);
    builder.append(", name=");
    builder.append(name);
    builder.append(", currency=");
    builder.append(currency);
    builder.append("]");
    return builder.toString();
  }

}
