package com.example.demo.instructor.model;

import com.example.demo.classes.model.Classes;
import com.example.demo.classifiers.model.Classifier;
import jakarta.persistence.*;

import java.util.List;


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

    public Instructor() {
    }

    public Instructor(long id, String name, String mail, String phone, String gender) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", classes=" + classes +
                ", classifiers=" + classifiers +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }

    public List<Classifier> getClassifiers() {
        return classifiers;
    }

    public void setClassifiers(List<Classifier> classifiers) {
        this.classifiers = classifiers;
    }

}
