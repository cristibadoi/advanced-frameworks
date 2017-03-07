package com.cristibadoi.automarket.persistence.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class CurrencyModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(unique = true, nullable = false)
  private String code;

  @OneToMany(mappedBy = "currency")
  private List<CountryModel> countries;

  @OneToMany(mappedBy = "currency")
  private List<PostModel> posts;

  public CurrencyModel() {
  }

  public CurrencyModel(String code) {
    this.code = code;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public List<CountryModel> getCountries() {
    return countries;
  }

  public void setCountries(List<CountryModel> countries) {
    this.countries = countries;
  }

  public List<PostModel> getPosts() {
    return posts;
  }

  public void setPosts(List<PostModel> posts) {
    this.posts = posts;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((code == null) ? 0 : code.hashCode());
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
    CurrencyModel other = (CurrencyModel) obj;
    if (code == null) {
      if (other.code != null)
        return false;
    } else if (!code.equals(other.code))
      return false;
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CurrencyModel [id=");
    builder.append(id);
    builder.append(", code=");
    builder.append(code);
    builder.append(", countries=");
    builder.append(countries);
    builder.append("]");
    return builder.toString();
  }

}
