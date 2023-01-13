package com.example.demo.client.service;

import com.example.demo.balance.model.Balance;
import com.example.demo.balance.repository.BalanceRepository;
import com.example.demo.client.exceptions.*;
import com.example.demo.client.model.Client;
import com.example.demo.client.model.Role;
import com.example.demo.client.repository.ClientRepository;
import com.example.demo.client.repository.RoleRepository;
import com.example.demo.config.RoleConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BalanceRepository balanceRepository;

    public Client getClient(
            Long id
    ) throws ClientNotFoundException {
        Optional<Client> client = clientRepository.findById(id);

        if (client.isEmpty())
            throw new ClientNotFoundException();

        return client.get();
    }

    public Long addUser(
            String name,
            String mail,
            String phone,
            String gender
    ) throws MailNotFoundException, PhoneNotFoundException, MailIsAlreadyExistException, PhoneIsAlreadyExistException {
        if (mail == null)
            throw new MailNotFoundException();
        if (phone == null)
            throw new PhoneNotFoundException();
        Client clientMail = clientRepository.getClientByMail(mail);
        if (clientMail != null)
            throw new MailIsAlreadyExistException();
        Client clientPhone = clientRepository.getClientByPhone(phone);
        if (clientPhone != null)
            throw new PhoneIsAlreadyExistException();

        Role role = roleRepository.getRoleByRole(RoleConfig.ROLE_USER.toString());
        Client client = new Client(
                name,
                mail,
                phone,
                gender,
                role,
                null
        );
        Balance balance = new Balance(balanceRepository.count() + 1, (float) 0, role);
        Balance balance1 = balanceRepository.save(balance);
        client.setBalance(balance1);
        return clientRepository.save(client).getId();
    }

    public List<Client> getAllClients() {
        return clientRepository.getAllClients();
    }



}
