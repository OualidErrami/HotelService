package org.sid.hotelservice.controllers;


import org.sid.hotelservice.Auth.AuthenticationRequest;
import org.sid.hotelservice.Auth.AuthenticationResponse;
import org.sid.hotelservice.entities.Compte_client;
import org.sid.hotelservice.repostories.Compte_clientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@CrossOrigin("*")
public class CompteController {
    @Autowired
    private Compte_clientRepository clientRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/SignUp")
    public String SignUp(@RequestBody Compte_client compteClient){
      try{clientRepository.save(compteClient);}
      catch (Exception e){
         return e+"";
      }
      return "Compte added "+ compteClient.getId();
    }
    @PostMapping("/SignIn")
    public ResponseEntity<?> SignIn(@RequestBody AuthenticationRequest request){
    String email= request.getEmail();
    String password= request.getPassword();
    try {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
    }
    catch (Exception e){
        return ResponseEntity.ok(new AuthenticationResponse("failure "+email));
    }
    return ResponseEntity.ok(new AuthenticationResponse("Success "+email) );
    }
    @GetMapping("/account")
    public List<Compte_client> getaccounts(){
        return clientRepository.findAll();
    }
}
