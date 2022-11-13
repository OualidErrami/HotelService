package org.sid.hotelservice.controllers;


import org.sid.hotelservice.Auth.AuthenticationRequest;
import org.sid.hotelservice.Auth.AuthenticationResponse;
import org.sid.hotelservice.Auth.JwtUtils;
import org.sid.hotelservice.Auth.UserService;
import org.sid.hotelservice.entities.Compte_client;
import org.sid.hotelservice.repostories.Compte_clientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@CrossOrigin("http://localhost:4200/")
public class CompteController {
    private final Compte_clientRepository clientRepository;

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public CompteController(Compte_clientRepository clientRepository, AuthenticationManager authenticationManager, UserService userService, JwtUtils jwtUtils) {
        this.clientRepository = clientRepository;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    private  final JwtUtils jwtUtils;

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
        return ResponseEntity.ok(e);
    }
    UserDetails loadUser =userService.loadUserByUsername(email);
    String generatedToken= jwtUtils.generateToken(loadUser);
    return ResponseEntity.ok( new AuthenticationResponse(request.getEmail(),generatedToken));
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/account")
    public List<Compte_client> getaccounts(){
        return clientRepository.findAll();
    }

    @PostMapping("/userbytoken")
    public Compte_client getaccount(@RequestBody String token){
        String username= jwtUtils.extractUsername(token);
        return clientRepository.findByEmail(username);
    }
}
