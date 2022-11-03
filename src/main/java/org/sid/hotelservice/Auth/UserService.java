package org.sid.hotelservice.Auth;

import org.sid.hotelservice.entities.Compte_client;
import org.sid.hotelservice.repostories.Compte_clientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private Compte_clientRepository clientRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Compte_client compteClient =clientRepository.findByEmail(email);
        if(compteClient==null) return null;
        String username=compteClient.getEmail();
        String password=compteClient.getPassword();
    return new User(username,password,new ArrayList<>());
    }
}
