package com.lowcontext.restapijava.models.dto;

public record RegisterRequest(
    String name,
    String email,
    String password,
    String confirmpassword
) {}
