package com.project.SmartInvoiceTracker.service.clientService;

import com.project.SmartInvoiceTracker.entity.client.Client;
import com.project.SmartInvoiceTracker.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void addClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Optional<Client> getClientByUserId(Long userId){
        return clientRepository.findById(userId);
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Client updatedClient) {
        return clientRepository.save(updatedClient);
    }
}
