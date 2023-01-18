package com.example.demo.studio.model;

import com.example.demo.classifiers.model.Classifier;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pos")
public class Position {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "working_hours", nullable = false)
    private String hours;

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    private Studio studio;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "pos_classifier_relation",
            joinColumns = { @JoinColumn(name = "pos_id") },
            inverseJoinColumns = { @JoinColumn(name = "classifier_id") }
    )
    List<Classifier> classifiers;

    public Position() {
    }

    public Position(long id, String address, String hours, Studio studio) {
        this.id = id;
        this.address = address;
        this.hours = hours;
        this.studio = studio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public List<Classifier> getClassifiers() {
        return classifiers;
    }

    public void setClassifiers(List<Classifier> classifiers) {
        this.classifiers = classifiers;
    }


    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", hours='" + hours + '\'' +
                ", studioId=" + studio.getId() +
                ", classifiers=" + classifiers +
                '}';
    }
}
