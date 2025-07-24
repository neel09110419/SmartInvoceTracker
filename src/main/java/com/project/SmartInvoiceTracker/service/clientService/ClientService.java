package com.project.SmartInvoiceTracker.service.clientService;

import com.project.SmartInvoiceTracker.entity.client.Client;

import java.util.Optional;

public interface ClientService {
    public void addClient(Client client);

    Optional<Client> getClientByUserId(Long userId);

    Optional<Client> getClientById(Long id);

    void deleteClient(Long id);

    Client updateClient(Client updatedClient);
}
