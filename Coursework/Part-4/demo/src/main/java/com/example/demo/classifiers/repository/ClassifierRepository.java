package com.example.demo.classifiers.repository;

import com.example.demo.classifiers.model.Classifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassifierRepository extends JpaRepository<Classifier, Long> {
    public Classifier getClassifierById(Long id);
    public Classifier getClassifierByNameAndValue(String name, String value);
    @Query(value = "select * from classifier", nativeQuery = true)
    public List<Classifier> getAllClassifiers();
}
