package org.jdtbee.spr.webapp.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Publisher {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String publisherName;
  private String address;
  private String city;
  private String state;
  private String zipCode;

  @OneToMany(mappedBy = "publisher")
  private Set<Book> books = new HashSet();


  public Publisher() {
    super();
  }

  public Publisher(String publisherName, String address, String city, String state, String zipCode,
      Set<Book> books) {
    super();
    this.publisherName = publisherName;
    this.address = address;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
    this.books = books;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPublisherName() {
    return publisherName;
  }

  public void setPublisherName(String publisherName) {
    this.publisherName = publisherName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, books, city, id, publisherName, state, zipCode);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Publisher other = (Publisher) obj;
    return Objects.equals(address, other.address) && Objects.equals(books, other.books)
        && Objects.equals(city, other.city) && Objects.equals(id, other.id)
        && Objects.equals(publisherName, other.publisherName) && Objects.equals(state, other.state)
        && Objects.equals(zipCode, other.zipCode);
  }

  @Override
  public String toString() {
    return "Publisher [id=" + id + ", publisherName=" + publisherName + ", address=" + address
        + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", books=" + books + "]";
  }

}
