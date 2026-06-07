package com.lowcontext.restapijava.models.dto;

import java.time.LocalDateTime;

public record UserResponse(
    String name,
    String email,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}
