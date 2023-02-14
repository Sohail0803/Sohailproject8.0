package com.kkjavatutorials.SpringBootRestApp.model;

import javax.persistence.*;

@Entity
@Table(name="ApplePay")
public class Apple {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="HEADING",length=50000)
    private String Heading;
    @Column(name="PARA",length=60000)
    private  String Para;
    public Apple(){
        super();
    }

    public Apple(String heading, String para) {
        Heading = heading;
        Para = para;
    }

    public Apple(Long id, String heading, String para) {
        super();
        this.id = id;
        this.Heading = heading;
        this.Para = para;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeading() {
        return Heading;
    }

    public void setHeading(String heading) {
        this.Heading = heading;
    }

    public String getPara() {
        return Para;
    }

    public void setPara(String para) {
        this.Para = para;
    }
}
