package com.cristibadoi.automarket.persistence.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(unique = true, nullable = false)
  private String email;

  @Column(unique = true, nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false, columnDefinition = "TINYINT(1)")
  private boolean enabled;

  @OneToMany(mappedBy = "user")
  private List<PostModel> posts;

  @OneToMany(mappedBy = "sender")
  private List<MessageModel> sentMessages;

  @OneToMany(mappedBy = "receiver")
  private List<MessageModel> receivedMessages;

  @ManyToMany
  @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private List<RoleModel> roles;

  public UserModel() {
  }

  public UserModel(String email, String password) {
    this.email = email;
    this.password = password;
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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public List<PostModel> getPosts() {
    return posts;
  }

  public void setPosts(List<PostModel> posts) {
    this.posts = posts;
  }

  public List<MessageModel> getSentMessages() {
    return sentMessages;
  }

  public void setSentMessages(List<MessageModel> sentMessages) {
    this.sentMessages = sentMessages;
  }

  public List<MessageModel> getReceivedMessages() {
    return receivedMessages;
  }

  public void setReceivedMessages(List<MessageModel> receivedMessages) {
    this.receivedMessages = receivedMessages;
  }

  public List<RoleModel> getRoles() {
    return roles;
  }

  public void setRoles(List<RoleModel> roles) {
    this.roles = roles;
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
    UserModel other = (UserModel) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("UserModel [id=");
    builder.append(id);
    builder.append(", email=");
    builder.append(email);
    builder.append(", username=");
    builder.append(username);
    builder.append(", password=");
    builder.append(password);
    builder.append(", enabled=");
    builder.append(enabled);
    builder.append("]");
    return builder.toString();
  }

}
