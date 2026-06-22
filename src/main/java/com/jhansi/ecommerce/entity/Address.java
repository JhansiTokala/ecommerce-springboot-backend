package com.jhansi.ecommerce.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String mobile;

    private String addressLine;

    private String city;

    private String state;

    private String pincode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Address() {
    }

    // Generate Constructor
    // Generate Getters
    // Generate Setters

    public Address(Long id, String fullName, String mobile, String city, String pincode, String addressLine, String state, User user) {
        this.id = id;
        this.fullName = fullName;
        this.mobile = mobile;
        this.city = city;
        this.pincode = pincode;
        this.addressLine = addressLine;
        this.state = state;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
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

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}