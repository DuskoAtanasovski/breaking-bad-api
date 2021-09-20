package com.breakingbad.service;

import com.breakingbad.dto.request.LoginRequest;
import com.breakingbad.dto.request.RegisterRequest;
import com.breakingbad.dto.response.AuthenticationResponse;

public interface AuthService {

    void signup(RegisterRequest registerRequest);

    void verifyAccount(String token);

    AuthenticationResponse login(LoginRequest loginRequest);
}
