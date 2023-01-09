package com.example.demo.classes.model;

import com.example.demo.classifiers.model.Classifier;
import com.example.demo.studio.model.Position;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "class")
public class Classes {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date_of", nullable = false)
    private Date date;

    @Column(name = "start_time", nullable = false)
    private Time startTime;

    @Column(name = "end_time", nullable = false)
    private Time endTime;

    @Column(name = "amount")
    private float amount;

    @ManyToOne
    @JoinColumn(name = "pos_id", nullable = false)
    private Position position;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "class_classifier_relation",
            joinColumns = { @JoinColumn(name = "class_id") },
            inverseJoinColumns = { @JoinColumn(name = "classifier_id") }
    )
    List<Classifier> classifiers;
}
