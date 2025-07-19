package com.project.SmartInvoceTracker.repository;

import com.project.SmartInvoceTracker.entity.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
