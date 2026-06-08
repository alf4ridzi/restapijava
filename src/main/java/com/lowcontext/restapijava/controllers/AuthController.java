package com.lowcontext.restapijava.controllers;

import com.lowcontext.restapijava.models.dto.JSendResponse;
import com.lowcontext.restapijava.models.dto.RegisterRequest;
import com.lowcontext.restapijava.models.dto.UserResponse;
import com.lowcontext.restapijava.services.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    protected AuthServiceImpl authService;

    @GetMapping(path = "/login")
    public String login() {
        return "login";
    }

    @PostMapping(
        path = "/register",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<JSendResponse<UserResponse>> register(
        @RequestBody RegisterRequest registerRequest
    ) {
        UserResponse user = authService.register(registerRequest);

        return ResponseEntity.ok(JSendResponse.success(user));
    }
}
