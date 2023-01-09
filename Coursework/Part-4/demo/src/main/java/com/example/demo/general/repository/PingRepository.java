package com.example.demo.general.repository;

import com.example.demo.general.model.Ping;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PingRepository extends JpaRepository<Ping, Long> {
}
