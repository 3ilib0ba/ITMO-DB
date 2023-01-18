package com.example.demo.classifiers.service;

import com.example.demo.classifiers.exceptions.ClassifierNotFoundException;
import com.example.demo.classifiers.model.Classifier;
import com.example.demo.classifiers.repository.ClassifierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifiersService {
    @Autowired
    private ClassifierRepository classifierRepository;

    public Classifier getClassifierById(Long id)
            throws ClassifierNotFoundException {
        Classifier result = classifierRepository.getClassifierById(id);
        if (result == null)
            throw new ClassifierNotFoundException();

        return result;
    }

    public Classifier getClassifierByNameAndValue(
            String name,
            String value
    ) throws ClassifierNotFoundException {
        Classifier result = classifierRepository.getClassifierByNameAndValue(name, value);
        if (result == null)
            throw new ClassifierNotFoundException();

        return result;
    }

    public List<Classifier> getAllClassifiers() {
        return classifierRepository.getAllClassifiers();
    }

    public Classifier addNewClassifier(
            String name, String value
    ) {
        return classifierRepository.save(
                new Classifier(classifierRepository.count() + 1, value, name)
        );
    }

}
