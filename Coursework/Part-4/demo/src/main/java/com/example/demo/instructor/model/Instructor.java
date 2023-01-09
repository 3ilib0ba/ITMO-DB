package com.example.demo.instructor.model;

import com.example.demo.classes.model.Classes;
import com.example.demo.classifiers.model.Classifier;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "gender", nullable = false)
    private String gender;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "instructor_class_relation",
            joinColumns = { @JoinColumn(name = "instructor_id") },
            inverseJoinColumns = { @JoinColumn(name = "class_id") }
    )
    List<Classes> classes;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "instructor_classifier_relation",
            joinColumns = { @JoinColumn(name = "instructor_id") },
            inverseJoinColumns = { @JoinColumn(name = "classifier_id") }
    )
    List<Classifier> classifiers;
}
