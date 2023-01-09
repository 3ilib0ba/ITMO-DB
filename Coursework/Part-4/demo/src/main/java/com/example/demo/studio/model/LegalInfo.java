package com.example.demo.studio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "legal_info")
public class LegalInfo {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_description")
    private String fullDescription;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "TIN", nullable = false)
    private String TIN;
}
