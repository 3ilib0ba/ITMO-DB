package com.example.demo.general.service;

import com.example.demo.general.model.Ping;
import com.example.demo.general.repository.PingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class PingService {

    @Autowired
    private PingRepository pingRepository;

    public void addNewPingFromNow() {
        Ping ping_current = new Ping(new Time(System.currentTimeMillis()));
        pingRepository.save(ping_current);
    }

    public List<Ping> getAllPings() {
        return pingRepository.findAll();
    }

}
