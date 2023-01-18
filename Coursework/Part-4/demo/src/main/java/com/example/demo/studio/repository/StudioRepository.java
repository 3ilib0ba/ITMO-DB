package com.example.demo.studio.repository;

import com.example.demo.studio.model.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {
    public Studio getStudioById(Long id);

    public Studio getStudioByName(String studioName);

    @Query(value = "select * from studio", nativeQuery = true)
    public List<Studio> getAllStudios();
}
