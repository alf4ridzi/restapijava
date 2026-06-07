package com.lowcontext.restapijava.services;

import com.lowcontext.restapijava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public void validateLogin() {}

    public void register() {}
}
