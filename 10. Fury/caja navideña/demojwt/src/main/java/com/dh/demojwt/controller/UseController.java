package com.dh.demojwt.controller;

import com.dh.demojwt.model.User;
import com.dh.demojwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

;import java.net.Authenticator;

@RestController
@RequestMapping("/api/v1/users")
public class UseController {

    @GetMapping("/buyer-1")
    public String buyer( Authentication authentication) {
        return "user with buyer: " + authentication.getName() + " - " + authentication.getAuthorities();
    }

    @GetMapping("/buyer-2")
    public String buyer2(Authentication authentication) {
        return "user with buyer: " + authentication.getName() + " - " + authentication.getAuthorities();
    }

    @GetMapping("admin-1")
    public String admin1(Authentication authentication) {
        return "user with admin: " + authentication.getName() + " - " + authentication.getAuthorities();
    }

    @GetMapping("admin-2")
    public String admin2(Authentication authentication) {
        return "user with admin: " + authentication.getName() + " - " + authentication.getAuthorities();
    }
}
