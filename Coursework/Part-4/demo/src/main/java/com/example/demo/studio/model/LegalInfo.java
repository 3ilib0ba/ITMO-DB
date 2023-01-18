package com.example.demo.studio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "legal_info")
public class LegalInfo {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "full_description")
    private String fullDescription;

    @Column(name = "contact_phone")
    private String phone;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "TIN", nullable = false)
    private String TIN;

    public LegalInfo() {
    }
    public LegalInfo(long id, String fullDescription, String phone, String mail, String TIN) {
        this.id = id;
        this.fullDescription = fullDescription;
        this.phone = phone;
        this.mail = mail;
        this.TIN = TIN;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTIN() {
        return TIN;
    }

    public void setTIN(String TIN) {
        this.TIN = TIN;
    }

    @Override
    public String toString() {
        return "LegalInfo{" +
                "id=" + id +
                ", fullDescription='" + fullDescription + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", TIN='" + TIN + '\'' +
                '}';
    }
}
