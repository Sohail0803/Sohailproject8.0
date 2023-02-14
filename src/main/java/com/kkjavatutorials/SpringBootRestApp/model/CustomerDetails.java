package com.kkjavatutorials.SpringBootRestApp.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class CustomerDetails {

    @OneToMany(mappedBy = "customer")
    Set<RelationshipDetails> relationshipDetailsList = new LinkedHashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String customerName;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String pan;
    @Column
    private String address;

    @Column
    private Long mobileNumber;

    public CustomerDetails(String customerName, String username, String password, String email, Long mobileNumber, String address, String pan) {
        this.customerName = customerName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.pan = pan;
        this.address = address;
    }

    public CustomerDetails() {
    }

    public Long getId() {
        return id;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Set<RelationshipDetails> getRelationshipDetailsList() {
        return relationshipDetailsList;
    }

    public void addRelationship(RelationshipDetails relationshipDetails) {
        this.relationshipDetailsList.add(relationshipDetails);
    }


}