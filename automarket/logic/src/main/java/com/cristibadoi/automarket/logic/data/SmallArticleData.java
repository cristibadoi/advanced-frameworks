package com.cristibadoi.automarket.logic.data;

import java.util.Date;

public class SmallArticleData {

  private long id;
  private int modelYear;
  private int mileage;
  private int price;
  private String imageLink;
  private Date publicationDate;
  private int cylindricalCapacity;
  private String brandName;
  private String modelName;
  private String fuelName;
  private String cityName;
  private String type;

  public SmallArticleData() {
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

  public String getImageLink() {
    return imageLink;
  }

  public void setImageLink(String imageLink) {
    this.imageLink = imageLink;
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}