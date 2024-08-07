package com.example.projecttt.interfacesServices;

import com.example.projecttt.dto.SignupRequest;

import java.io.IOException;

public interface AuthService {
    boolean createUser(SignupRequest signupRequest) throws IOException;

}
