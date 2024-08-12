package com.example.projecttt.controllers;

import com.example.projecttt.dto.LoginRequest;
import com.example.projecttt.dto.LoginResponse;
import com.example.projecttt.services.LoginServiceImpl;
import com.example.projecttt.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/login")
public class LoginController {

    private  final AuthenticationManager authenticationManager;
    private final LoginServiceImpl loginService;
    private  final JWTUtil jwtUtil ;

    @Autowired
    public  LoginController(AuthenticationManager authenticationManager, LoginServiceImpl loginService, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.loginService = loginService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        System.out.printf("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        try {
            System.out.println("Attempting authentication");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
            System.out.println("Authentication Successful");

            UserDetails userDetails;
            try {
                userDetails = loginService.loadUserByUsername(loginRequest.getEmail());
                System.out.println("User details loaded");
            } catch (UsernameNotFoundException e) {
                System.out.println("Username not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            String jwt = jwtUtil.generateToken(userDetails.getUsername());
            System.out.println("JWT token generated");

            return ResponseEntity.ok(new LoginResponse(jwt));
        } catch (Exception e) {
            System.out.println("Authentication failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}




