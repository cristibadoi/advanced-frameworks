package com.cristibadoi.automarket.persistence.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RoleModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(unique = true, nullable = false)
  private String name;

  @ManyToMany(mappedBy = "roles")
  private List<UserModel> users;

  public RoleModel() {
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

  public List<UserModel> getUsers() {
    return users;
  }

  public void setUsers(List<UserModel> users) {
    this.users = users;
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
    RoleModel other = (RoleModel) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("RoleModel [id=");
    builder.append(id);
    builder.append(", name=");
    builder.append(name);
    builder.append(", users=");
    builder.append(users);
    builder.append("]");
    return builder.toString();
  }

}
