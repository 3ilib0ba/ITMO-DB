package com.example.demo.client.repository;

import com.example.demo.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    public Client getClientByPhone(String phone);

    public Client getClientByMail(String mail);

    @Query(value = "select * from client", nativeQuery = true)
    public List<Client> getAllClients();
}
