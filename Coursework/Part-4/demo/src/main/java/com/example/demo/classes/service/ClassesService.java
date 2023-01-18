package com.example.demo.classes.service;

import com.example.demo.classes.exceptions.ClassesNotFoundException;
import com.example.demo.classes.model.Classes;
import com.example.demo.classes.repository.ClassRepository;
import com.example.demo.studio.exceptions.PositionNotFoundException;
import com.example.demo.studio.model.Position;
import com.example.demo.studio.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;

@Service
public class ClassesService {
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private PositionService positionService;

    public Classes getClassById(Long id)
            throws ClassesNotFoundException {
        Classes result = classRepository.getClassesById(id);
        if (result == null)
            throw new ClassesNotFoundException();

        return result;
    }

    public Classes addClass(
            String name,
            // date format from string yyyy-[m]m-[d]d
            Date date,
            // time format from string hh:mm:ss
            Time start,
            Time end,
            Float amount,
            Long posId
    ) throws PositionNotFoundException {
        Position positionOf = positionService.getPositionById(posId);
        Classes classes = new Classes(classRepository.count() + 1, name, date, start, end, amount, positionOf);

        return classRepository.save(classes);
    }

}
