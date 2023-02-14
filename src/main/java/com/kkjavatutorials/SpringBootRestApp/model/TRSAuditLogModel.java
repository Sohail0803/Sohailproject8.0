package com.kkjavatutorials.SpringBootRestApp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRSAuditlog")
public class TRSAuditLogModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "request")
    private String request;
    @Column(name = "status")
    private String status;


    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date createdAt = new Date(System.currentTimeMillis());

    @Column(name = "created_atDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date createdAtDate = new Date(System.currentTimeMillis());


    public TRSAuditLogModel(long id, Date createdAt, Date createdAtDate, String request, String status) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.createdAtDate = createdAtDate;
        this.request = request;
        this.status = status;
    }

    public TRSAuditLogModel() {
        super();
        // TODO Auto-generated constructor stub
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAtDate() {
        return createdAtDate;
    }

    public void setCreatedAtDate(Date createdAtDate) {
        this.createdAtDate = createdAtDate;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AuditLog{" +
                "id=" + id +
                ", request='" + request + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
