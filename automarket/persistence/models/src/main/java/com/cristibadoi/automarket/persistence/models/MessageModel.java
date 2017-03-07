package com.cristibadoi.automarket.persistence.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class MessageModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private String text;
  
  @Column(nullable = false)
  private int date;

  @ManyToOne
  @JoinColumn(name = "sender_id", referencedColumnName = "id", nullable = false)
  private UserModel sender;

  @ManyToOne
  @JoinColumn(name = "receiver_id", referencedColumnName = "id", nullable = false)
  private UserModel receiver;

  public MessageModel() {
  }

  public MessageModel(String text, UserModel sender, UserModel receiver) {
    this.text = text;
    this.sender = sender;
    this.receiver = receiver;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getDate() {
    return date;
  }

  public void setDate(int date) {
    this.date = date;
  }

  public UserModel getSender() {
    return sender;
  }

  public void setSender(UserModel sender) {
    this.sender = sender;
  }

  public UserModel getReceiver() {
    return receiver;
  }

  public void setReceiver(UserModel receiver) {
    this.receiver = receiver;
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
    MessageModel other = (MessageModel) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("MessageModel [id=");
    builder.append(id);
    builder.append(", text=");
    builder.append(text);
    builder.append(", date=");
    builder.append(date);
    builder.append(", sender=");
    builder.append(sender);
    builder.append(", receiver=");
    builder.append(receiver);
    builder.append("]");
    return builder.toString();
  }

}
