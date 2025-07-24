package com.project.SmartInvoiceTracker.repository;

import com.project.SmartInvoiceTracker.entity.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Override
    List<Client> findAllById(Iterable<Long> longs);
}
