package com.example.demo.booking.model;

import com.example.demo.classes.model.Classes;
import com.example.demo.client.model.Client;
import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Classes bookingClass;

    public Booking() {
    }

    public Booking(long id, Client client, Classes bookingClass) {
        this.id = id;
        this.client = client;
        this.bookingClass = bookingClass;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", client=" + client +
                ", bookingClass=" + bookingClass +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Classes getBookingClass() {
        return bookingClass;
    }

    public void setBookingClass(Classes bookingClass) {
        this.bookingClass = bookingClass;
    }
}
