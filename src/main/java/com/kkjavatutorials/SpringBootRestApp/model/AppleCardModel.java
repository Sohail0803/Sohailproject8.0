package com.kkjavatutorials.SpringBootRestApp.model;

import javax.persistence.*;

@Entity
@Table(name = "AppleCards")
public class AppleCardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Apple_id")
    private Long id;
    private  Long cardnumber;
    private String cardname;
    private boolean agreed;
    private boolean digitized;

    public AppleCardModel() {
    }

    public AppleCardModel(Long id, Long cardnumber, String cardname, boolean agreed, boolean digitized) {
        this.id = id;
        this.cardnumber = cardnumber;
        this.cardname = cardname;
        this.agreed = agreed;
        this.digitized = digitized;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(Long cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public boolean isAgreed() {
        return agreed;
    }

    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }

    public boolean isDigitized() {
        return digitized;
    }

    public void setDigitized(boolean digitized) {
        this.digitized = digitized;
    }
}