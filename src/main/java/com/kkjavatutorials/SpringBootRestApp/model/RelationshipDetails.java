package com.kkjavatutorials.SpringBootRestApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class RelationshipDetails {


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "Customer_Relationship", joinColumns = @JoinColumn(name = "Relationship_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private CustomerDetails customer;
    private Long customerid;
    private String customerName;
    private String relationshipName;
    private byte approvalStatus;
    @Column(name = "relationship_Type")
    private String relationshipType;
    @Column(name = "relationship_Number")
    private long relationshipnumber;

    public RelationshipDetails(Long customerid, String customerName, String relationshipName, String relationshipType) {
        this.customerid = customerid;
        this.customerName = customerName;
        this.relationshipName = relationshipName;
        this.relationshipType = relationshipType;
    }

    public RelationshipDetails() {
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public long getRelationshipnumber() {
        return relationshipnumber;
    }

    public void setRelationshipnumber(long relationshipnumber) {
        this.relationshipnumber = relationshipnumber;
    }

    public Long getId() {
        return id;
    }


    public Long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRelationshipName() {
        return relationshipName;
    }

    public void setRelationshipName(String relationshipName) {
        this.relationshipName = relationshipName;
    }

    public byte getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(byte approvalStatus) {
        this.approvalStatus = approvalStatus;
    }



    public CustomerDetails getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDetails customer) {
        this.customer = customer;
    }



}
