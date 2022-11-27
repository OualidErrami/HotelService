package org.sid.hotelservice.controllers;

import org.sid.hotelservice.entities.Reservation;
import org.sid.hotelservice.entities.Room;
import org.sid.hotelservice.repostories.Compte_clientRepository;
import org.sid.hotelservice.repostories.ReservationRepository;
import org.sid.hotelservice.repostories.RoomRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@RequestMapping("/service")
@RestController
@CrossOrigin("http://localhost:4200/")

public class ReservationController {

    private final ReservationRepository reservationRepository;

    private final RoomRepository roomRepository;
    private final Compte_clientRepository clientRepository;

    public ReservationController(ReservationRepository reservationRepository, RoomRepository roomRepository, Compte_clientRepository clientRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
        this.clientRepository = clientRepository;
    }


    @GetMapping("/getrooms")
    public List<Reservation> reservationList(){
      return reservationRepository.findAll();
    }

    @PostMapping("/MakeReservation")
    public ResponseEntity<?> makeReservation(@RequestBody Reservation reservation){

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter timeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
       try {
           Room status=roomRepository.random().getMappedResults().stream().findFirst().orElse(null);
           assert status != null;
            status.setState(true);
            reservation.setDateDeReservation(myDateObj.format(timeFormatter));
            reservation.setClient(clientRepository.findByEmail(reservation.getClient().getEmail()));
            reservation.setRoom(status);
            reservation.setDateDeDebut(reservation.getDateDeDebut().formatted(timeFormatter));
            reservation.setDateDeFin(reservation.getDateDeFin().formatted(timeFormatter));
            reservationRepository.save(reservation);
            roomRepository.save(status);
            return ResponseEntity.ok("reservation has been done with success");
        }
       catch(Exception e){
        return ResponseEntity.ok("Deja reserve"+e);
       }

    }
}
