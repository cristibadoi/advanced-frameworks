package com.cristibadoi.automarket.persistence.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "fuel")
public class FuelModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(unique = true, nullable = false)
  private String name;

  @OneToMany(mappedBy = "fuel")
  private List<ArticleModel> articles;

  public FuelModel() {
  }

  public FuelModel(String name) {
    this.name = name;
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

  public List<ArticleModel> getArticles() {
    return articles;
  }

  public void setArticles(List<ArticleModel> articles) {
    this.articles = articles;
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
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    FuelModel other = (FuelModel) obj;
    if (id != other.id) {
      return false;
    }
    return true;
  }

}
