package com.lowcontext.restapijava.models.dto;

public record RegisterRequest(
    String nama,
    String email,
    String password,
    String confirmpassword
) {}
