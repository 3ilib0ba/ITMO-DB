package com.example.demo.studio.repository;

import com.example.demo.studio.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

    public Position getPositionsByAddress(String address);

    public Position getPositionsById(Long id);

    public List<Position> getPositionsByStudio_Id(Long studioId);

}
