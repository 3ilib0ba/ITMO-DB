package com.example.demo.classifiers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "classifier")
public class Classifier {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "classifier_value", nullable = false)
    private String value;

    @Column(name = "classifier_name", nullable = false)
    private String name;
}
