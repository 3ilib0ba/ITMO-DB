package com.example.demo.classifiers.model;

import jakarta.persistence.*;

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

    public Classifier() {
    }

    public Classifier(long id, String value, String name) {
        this.id = id;
        this.value = value;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Classifier{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
