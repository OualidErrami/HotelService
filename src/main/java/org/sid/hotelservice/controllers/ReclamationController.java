package org.sid.hotelservice.controllers;

import org.sid.hotelservice.entities.Reclamation;
import org.sid.hotelservice.repostories.Compte_clientRepository;
import org.sid.hotelservice.repostories.ReclamationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reclamation")
public class ReclamationController {

    private final ReclamationRepository repository;

    private final Compte_clientRepository clientRepository;

    public ReclamationController(ReclamationRepository repository, Compte_clientRepository clientRepository) {
        this.repository = repository;
        this.clientRepository = clientRepository;
    }

    @PostMapping("/makeReclamation")
    public ResponseEntity<?> makeReclamation(@RequestBody Reclamation reclamation){
        try {
            reclamation.setClient(clientRepository.findByEmail(reclamation.getClient().getEmail()));
            repository.save(reclamation);
            return ResponseEntity.ok("Reclamation sent");
        }
        catch (Exception e){
            return ResponseEntity.ok("Reclamation not  sent"+e);
        }
    }
    @GetMapping("/getReclamation")
    public List<Reclamation> getReclamation(){
        return repository.findAll();
    }
}
