package com.example.demo.classifiers.repository;

import com.example.demo.classifiers.model.Classifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassifierRepository extends JpaRepository<Classifier, Long> {
}
