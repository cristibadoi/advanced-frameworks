package com.cristibadoi.automarket.persistence.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "type")
public class TypeModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(unique = true, nullable = false)
  private String name;

  @OneToMany(mappedBy = "type")
  private List<ArticleModel> articles;

  public TypeModel() {
  }

  public TypeModel(String name) {
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

  public void setModels(List<ArticleModel> posts) {
    this.articles = posts;
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
    TypeModel other = (TypeModel) obj;
    if (id != other.id) {
      return false;
    }
    return true;
  }

}
