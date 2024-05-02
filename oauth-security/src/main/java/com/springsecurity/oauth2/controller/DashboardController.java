package com.springsecurity.oauth2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/oauth")
@RequiredArgsConstructor
public class DashboardController {

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PreAuthorize("hasAuthority('SCOPE_READ')")
    @GetMapping("/welcome-message")
    public ResponseEntity<String> getFirstWelcomeMessage(Authentication authentication){
        return ResponseEntity.ok("Bienvenido a Seguros Tu Papá: "+authentication.getName()+" Tus permisos son:"+authentication.getAuthorities());
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PreAuthorize("hasAuthority('SCOPE_WRITE')")
    @PostMapping("/admin-message")
    public ResponseEntity<String> getAdminData(@RequestParam("message") String message, Principal principal){
        return ResponseEntity.ok("Admin: "+principal.getName()+" tiene el siguiente mensaje: "+message);

    }
}