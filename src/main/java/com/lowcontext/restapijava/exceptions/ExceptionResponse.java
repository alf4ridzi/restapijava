package com.lowcontext.restapijava.exceptions;

import java.time.Instant;

public record ExceptionResponse(String status, Instant data, String message) {}
