package com.lowcontext.restapijava.services;

import com.lowcontext.restapijava.exceptions.ValidationException;
import com.lowcontext.restapijava.models.User;
import com.lowcontext.restapijava.models.dto.RegisterRequest;
import com.lowcontext.restapijava.models.dto.UserResponse;
import com.lowcontext.restapijava.repositories.UserRepository;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    public void validateLogin() {}

    @Override
    public UserResponse register(RegisterRequest registerRequest) {
        if (
            !registerRequest
                .password()
                .equals(registerRequest.confirmpassword())
        ) {
            throw new ValidationException(
                Map.of("confirmpassword", "password don't equals")
            );
        }

        User user = new User();

        user.setEmail(registerRequest.email());
        user.setName(registerRequest.name());
        user.setPasssword(registerRequest.password());

        userRepository.save(user);

        UserResponse userResponse = new UserResponse(
            user.getName(),
            user.getEmail(),
            user.getCreatedAt(),
            user.getUpdatedAt()
        );

        return userResponse;
    }
}
