package com.cristibadoi.automarket.logic.query;

public class QueryDetails {

  private String brandName;
  private String modelName;
  private String type;
  private String fuel;
  private int minCapacity;
  private int maxCapacity;
  private int minYear;
  private int maxYear;
  private int minMileage;
  private int maxMileage;
  private int minPrice;
  private int maxPrice;
  private String city;

  public QueryDetails() {
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getFuel() {
    return fuel;
  }

  public void setFuel(String fuel) {
    this.fuel = fuel;
  }

  public int getMinCapacity() {
    return minCapacity;
  }

  public void setMinCapacity(int minCapacity) {
    this.minCapacity = minCapacity;
  }

  public int getMaxCapacity() {
    return maxCapacity;
  }

  public void setMaxCapacity(int maxCapacity) {
    this.maxCapacity = maxCapacity;
  }

  public int getMinYear() {
    return minYear;
  }

  public void setMinYear(int minYear) {
    this.minYear = minYear;
  }

  public int getMaxYear() {
    return maxYear;
  }

  public void setMaxYear(int maxYear) {
    this.maxYear = maxYear;
  }

  public int getMinMileage() {
    return minMileage;
  }

  public void setMinMileage(int minMileage) {
    this.minMileage = minMileage;
  }

  public int getMaxMileage() {
    return maxMileage;
  }

  public void setMaxMileage(int maxMileage) {
    this.maxMileage = maxMileage;
  }

  public int getMinPrice() {
    return minPrice;
  }

  public void setMinPrice(int minPrice) {
    this.minPrice = minPrice;
  }

  public int getMaxPrice() {
    return maxPrice;
  }

  public void setMaxPrice(int maxPrice) {
    this.maxPrice = maxPrice;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("QueryDetails [brandName=");
    builder.append(brandName);
    builder.append(", modelName=");
    builder.append(modelName);
    builder.append(", type=");
    builder.append(type);
    builder.append(", fuel=");
    builder.append(fuel);
    builder.append(", minCapacity=");
    builder.append(minCapacity);
    builder.append(", maxCapacity=");
    builder.append(maxCapacity);
    builder.append(", minYear=");
    builder.append(minYear);
    builder.append(", maxYear=");
    builder.append(maxYear);
    builder.append(", minMileage=");
    builder.append(minMileage);
    builder.append(", maxMileage=");
    builder.append(maxMileage);
    builder.append(", minPrice=");
    builder.append(minPrice);
    builder.append(", maxPrice=");
    builder.append(maxPrice);
    builder.append(", city=");
    builder.append(city);
    builder.append("]");
    return builder.toString();
  }

}