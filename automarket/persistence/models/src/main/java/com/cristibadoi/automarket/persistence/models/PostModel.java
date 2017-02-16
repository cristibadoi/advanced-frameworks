package com.cristibadoi.automarket.persistence.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PostModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(nullable = false)
  private int modelYear;

  @Column(nullable = false)
  private int mileage;

  @Column(nullable = false)
  private int price;

  @Column(nullable = false)
  private String phoneNumber;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private String images;

  @Column(nullable = false)
  private int publicationDate;

  @Column(nullable = false)
  private int cylindricalCapacity;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
  private UserModel user;

  @ManyToOne
  @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false)
  private BrandModel brand;

  @ManyToOne
  @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false)
  private ModelModel model;

  @ManyToOne
  @JoinColumn(name = "fuel_id", referencedColumnName = "id", nullable = false)
  private FuelModel fuel;

  @ManyToOne
  @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
  private CityModel city;

  @ManyToOne
  @JoinColumn(name = "currency_id", referencedColumnName = "id", nullable = false)
  private CurrencyModel currency;

  @ManyToOne
  @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
  private StatusModel status;

  public PostModel() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getModelYear() {
    return modelYear;
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

  public String getImages() {
    return images;
  }

  public void setImages(String images) {
    this.images = images;
  }

  public int getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(int publicationDate) {
    this.publicationDate = publicationDate;
  }

  public int getCylindricalCapacity() {
    return cylindricalCapacity;
  }

  public void setCylindricalCapacity(int cylindricalCapacity) {
    this.cylindricalCapacity = cylindricalCapacity;
  }

  public UserModel getUser() {
    return user;
  }

  public void setUser(UserModel user) {
    this.user = user;
  }

  public BrandModel getBrand() {
    return brand;
  }

  public void setBrand(BrandModel brand) {
    this.brand = brand;
  }

  public ModelModel getModel() {
    return model;
  }

  public void setModel(ModelModel model) {
    this.model = model;
  }

  public FuelModel getFuel() {
    return fuel;
  }

  public void setFuel(FuelModel fuel) {
    this.fuel = fuel;
  }

  public CityModel getCity() {
    return city;
  }

  public void setCity(CityModel city) {
    this.city = city;
  }

  public CurrencyModel getCurrency() {
    return currency;
  }

  public void setCurrency(CurrencyModel currency) {
    this.currency = currency;
  }

  public StatusModel getStatus() {
    return status;
  }

  public void setStatus(StatusModel status) {
    this.status = status;
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
    PostModel other = (PostModel) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("PostModel [id=");
    builder.append(id);
    builder.append(", modelYear=");
    builder.append(modelYear);
    builder.append(", mileage=");
    builder.append(mileage);
    builder.append(", price=");
    builder.append(price);
    builder.append(", phoneNumber=");
    builder.append(phoneNumber);
    builder.append(", email=");
    builder.append(email);
    builder.append(", description=");
    builder.append(description);
    builder.append(", images=");
    builder.append(images);
    builder.append(", publicationDate=");
    builder.append(publicationDate);
    builder.append(", cylindricalCapacity=");
    builder.append(cylindricalCapacity);
    builder.append(", user=");
    builder.append(user);
    builder.append(", brand=");
    builder.append(brand);
    builder.append(", model=");
    builder.append(model);
    builder.append(", fuel=");
    builder.append(fuel);
    builder.append(", city=");
    builder.append(city);
    builder.append(", currency=");
    builder.append(currency);
    builder.append(", status=");
    builder.append(status);
    builder.append("]");
    return builder.toString();
  }

}