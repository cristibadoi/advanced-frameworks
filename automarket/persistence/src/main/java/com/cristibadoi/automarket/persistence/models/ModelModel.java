package com.cristibadoi.automarket.persistence.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "model")
public class ModelModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(unique = true, nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false)
  private BrandModel brand;

  @OneToMany(mappedBy = "model")
  private List<ArticleModel> articles;

  public ModelModel() {
  }

  public ModelModel(String name) {
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

  public BrandModel getBrand() {
    return brand;
  }

  public void setBrand(BrandModel brand) {
    this.brand = brand;
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
    ModelModel other = (ModelModel) obj;
    if (id != other.id) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("ModelModel [id=");
    builder.append(id);
    builder.append(", name=");
    builder.append(name);
    builder.append(", brand=");
    builder.append(brand);
    builder.append("]");
    return builder.toString();
  }

}
