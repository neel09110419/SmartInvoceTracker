package com.project.SmartInvoceTracker.repository;

import com.project.SmartInvoceTracker.entity.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(String email);

    boolean existByEmailId(String email);

}
