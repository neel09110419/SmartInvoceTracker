package com.project.SmartInvoiceTracker.controller;

import com.project.SmartInvoiceTracker.dto.auth.AuthResponse;
import com.project.SmartInvoiceTracker.dto.auth.LoginRequest;
import com.project.SmartInvoiceTracker.dto.auth.RegisterRequest;
import com.project.SmartInvoiceTracker.service.auth.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}