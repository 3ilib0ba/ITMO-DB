package com.example.demo.booking.repository;

import com.example.demo.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    public Booking getBookingById(Long id);

}
