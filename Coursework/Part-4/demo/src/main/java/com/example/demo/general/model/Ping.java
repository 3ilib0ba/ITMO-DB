package com.example.demo.general.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Table;
import java.sql.Time;

@Data
@Entity
@Getter
@Setter
@Table(name = "ping")
public class Ping {
    @jakarta.persistence.Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time_of_ping")
    private Time time_of_ping;

    public Ping(Time time) {
        this.time_of_ping = time;
    }

    public Ping() {
    }

    @Override
    public String toString() {
        return "id: " + id + ", time of it: " + time_of_ping.toString();
    }
}
