package com.cristibadoi.automarket.logic.data;

import java.util.Date;
import java.util.List;

public class FullArticleData {

  private long id;
  private int modelYear;
  private int mileage;
  private int price;
  private String phoneNumber;
  private String email;
  private String description;
  private List<String> imageLinks;
  private Date publicationDate;
  private int cylindricalCapacity;
  private String userName;
  private String brandName;
  private String modelName;
  private String fuelName;
  private String cityName;
  private String typeName;

  public FullArticleData() {
  }

  public int getModelYear() {
    return modelYear;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setModelYear(int modelYear) {
    this.modelYear = modelYear;
  }

  public int getMileage() {
    return mileage;
  }

  public void setMileage(int mileage) {
    this.mileage = mileage;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(Date publicationDate) {
    this.publicationDate = publicationDate;
  }

  public int getCylindricalCapacity() {
    return cylindricalCapacity;
  }

  public void setCylindricalCapacity(int cylindricalCapacity) {
    this.cylindricalCapacity = cylindricalCapacity;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public String getModelName() {
    return modelName;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  public String getFuelName() {
    return fuelName;
  }

  public void setFuelName(String fuelName) {
    this.fuelName = fuelName;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public List<String> getImageLinks() {
    return imageLinks;
  }

  public void setImageLinks(List<String> imageLinks) {
    this.imageLinks = imageLinks;
  }

}