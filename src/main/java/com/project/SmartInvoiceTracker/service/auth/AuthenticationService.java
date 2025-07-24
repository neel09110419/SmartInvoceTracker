package com.project.SmartInvoiceTracker.service.auth;


import com.project.SmartInvoiceTracker.dto.auth.AuthResponse;
import com.project.SmartInvoiceTracker.dto.auth.LoginRequest;
import com.project.SmartInvoiceTracker.dto.auth.RegisterRequest;
import com.project.SmartInvoiceTracker.entity.auth.Role;
import com.project.SmartInvoiceTracker.entity.auth.User;
import com.project.SmartInvoiceTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER); // Default role

        userRepository.save(user);

        String token = jwtUtils.generateToken(user.getEmail());
        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {
        Authentication auth = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
        authenticationManager.authenticate(auth); // Throws exception if invalid

        String token = jwtUtils.generateToken(request.getEmail());
        return new AuthResponse(token);
    }
}
