package org.sid.hotelservice.controllers;

import org.sid.hotelservice.entities.Reservation;
import org.sid.hotelservice.entities.Room;
import org.sid.hotelservice.repostories.Compte_clientRepository;
import org.sid.hotelservice.repostories.ReservationRepository;
import org.sid.hotelservice.repostories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RequestMapping("/service")
@RestController
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private Compte_clientRepository clientRepository;


    @GetMapping("/getrooms")
    public List<Reservation> reservationList(){
      return reservationRepository.findAll();
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @PostMapping("/MakeReservation")
    public ResponseEntity<?> makeReservation(@RequestBody Reservation reservation){
        Room status=roomRepository.findById(1).get();
       try {
            status.setReservationStatus(true);
            reservation.setDateDeReservation(new Date());
            reservation.setClient(clientRepository.findByEmail("walid.reale3@gmail.com"));
            reservation.setRoom(status);
            reservationRepository.save(reservation);
            roomRepository.save(status);
            return ResponseEntity.ok("reservation has been done with success");
        }
       catch(Exception e){
        return ResponseEntity.ok("Deja reserve");
       }

    }
}
