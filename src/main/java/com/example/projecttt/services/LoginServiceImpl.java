package com.example.projecttt.services;

import com.example.projecttt.entities.Utilisateur;
import com.example.projecttt.repositories.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class LoginServiceImpl implements UserDetailsService {
    @Autowired
    private final UtilisateurRepo userRepository ;
    @Autowired
    public LoginServiceImpl(UtilisateurRepo userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found" + email));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Collections.emptyList());

    }
}
