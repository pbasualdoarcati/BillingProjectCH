package com.billing.finalproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billing.finalproject.entity.Client;
import com.billing.finalproject.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Iterable<Client> findAll() {
        return clientRepository.findAll();

    }
}