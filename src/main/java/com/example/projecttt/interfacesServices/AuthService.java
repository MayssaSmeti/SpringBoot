package com.example.projecttt.interfacesServices;

import com.example.projecttt.dto.SignupRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AuthService {
    boolean createUser(SignupRequest signupRequest, MultipartFile pic) throws IOException;

}
