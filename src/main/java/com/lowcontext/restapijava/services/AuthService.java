package com.lowcontext.restapijava.services;

import com.lowcontext.restapijava.models.dto.RegisterRequest;
import com.lowcontext.restapijava.models.dto.UserResponse;

public interface AuthService {
    UserResponse register(RegisterRequest registerRequest);
}
