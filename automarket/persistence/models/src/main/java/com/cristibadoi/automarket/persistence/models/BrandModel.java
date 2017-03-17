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
@Table(name = "brand")
public class BrandModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(unique = true, nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
  private CountryModel country;

  @OneToMany(mappedBy = "brand")
  private List<ModelModel> models;

  @OneToMany(mappedBy = "brand")
  private List<PostModel> posts;

  public BrandModel() {
  }

  public BrandModel(String name, CountryModel country) {
    this.name = name;
    this.country = country;
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

  public CountryModel getCountry() {
    return country;
  }

  public void setCountry(CountryModel country) {
    this.country = country;
  }

  public List<ModelModel> getModels() {
    return models;
  }

  public void setModels(List<ModelModel> models) {
    this.models = models;
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
    BrandModel other = (BrandModel) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("BrandModel [id=");
    builder.append(id);
    builder.append(", name=");
    builder.append(name);
    builder.append(", country=");
    builder.append(country);
    builder.append("]");
    return builder.toString();
  }

}
