package com.example.demo.booking.service;

import com.example.demo.balance.model.Balance;
import com.example.demo.balance.repository.BalanceRepository;
import com.example.demo.booking.exceptions.BookingNotFoundException;
import com.example.demo.booking.exceptions.NotEnoughMoneyToBookException;
import com.example.demo.booking.model.Booking;
import com.example.demo.booking.repository.BookingRepository;
import com.example.demo.classes.exceptions.ClassesNotFoundException;
import com.example.demo.classes.model.Classes;
import com.example.demo.classes.service.ClassesService;
import com.example.demo.client.exceptions.ClientNotFoundException;
import com.example.demo.client.model.Client;
import com.example.demo.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ClassesService classesService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private BalanceRepository balanceRepository;

    public Booking getBookingById(Long id) throws BookingNotFoundException {
        Booking booking = bookingRepository.getBookingById(id);
        if (booking == null)
            throw new BookingNotFoundException();

        return booking;
    }

    public Booking addBooking(
            Long clientId,
            Long classId
    ) throws ClassesNotFoundException, ClientNotFoundException, NotEnoughMoneyToBookException {
        Client client = clientService.getClient(clientId);
        Classes classes = classesService.getClassById(classId);

        if (client.getBalance().getValue() < classes.getAmount())
            throw new NotEnoughMoneyToBookException();

        Balance balance = client.getBalance();
        balanceRepository.setNewBalanceById(balance.getId(), balance.getValue() - classes.getAmount());
        Balance balanceStudio = classes.getPosition().getStudio().getBalance();
        balanceRepository.setNewBalanceById(balanceStudio.getId(), balanceStudio.getValue() + classes.getAmount());

        return bookingRepository.save(new Booking(bookingRepository.count() + 1, client, classes));
    }
}
