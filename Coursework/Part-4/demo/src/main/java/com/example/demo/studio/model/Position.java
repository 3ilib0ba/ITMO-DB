package com.example.demo.studio.model;

import com.example.demo.classifiers.model.Classifier;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
}
