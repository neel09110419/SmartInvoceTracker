package com.project.SmartInvoiceTracker.service.UserService;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {

    public UserDetails loadUserByEmail(String email);
}
