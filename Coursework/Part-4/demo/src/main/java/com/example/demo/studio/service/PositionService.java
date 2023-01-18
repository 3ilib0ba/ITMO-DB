package com.example.demo.studio.service;

import com.example.demo.studio.exceptions.PositionNotFoundException;
import com.example.demo.studio.model.Position;
import com.example.demo.studio.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;

    public Position getPositionByAddress(String address)
            throws PositionNotFoundException {
        Position result = positionRepository.getPositionsByAddress(address);
        if (result == null)
            throw new PositionNotFoundException();

        return result;
    }

    public Position getPositionById(Long id)
            throws PositionNotFoundException {
        Position result = positionRepository.getPositionsById(id);
        if (result == null)
            throw new PositionNotFoundException();

        return result;
    }

    public List<Position> getAllPositionByStudioId(Long studioId)
            throws PositionNotFoundException {
        List<Position> result = positionRepository.getPositionsByStudio_Id(studioId);
        if (result == null)
            throw new PositionNotFoundException();

        return result;
    }
}
