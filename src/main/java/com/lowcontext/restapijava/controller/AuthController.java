package com.lowcontext.restapijava.controller;

import com.lowcontext.restapijava.models.dto.RegisterRequest;
import com.lowcontext.restapijava.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    protected AuthService authService;

    @GetMapping(path = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(
        path = "/register",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String register(@RequestBody RegisterRequest registerRequest) {
        return "register";
    }
}
