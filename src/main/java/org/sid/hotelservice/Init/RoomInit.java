package org.sid.hotelservice.Init;

import org.sid.hotelservice.entities.Reservation;
import org.sid.hotelservice.entities.Room;
import org.sid.hotelservice.repostories.PhotoRepository;
import org.sid.hotelservice.repostories.ReservationRepository;
import org.sid.hotelservice.repostories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RoomInit {
   private final RoomRepository roomRepositories;
    private final PhotoRepository photoRepository;
    private final ReservationRepository reservationRepository;
    public RoomInit(RoomRepository roomRepositories, PhotoRepository photoRepository, ReservationRepository reservationRepository) {
        this.roomRepositories = roomRepositories;
        this.photoRepository = photoRepository;
        this.reservationRepository = reservationRepository;
    }
    
    @PostConstruct
    public void createRooms() {
        roomRepositories.deleteAll();
        reservationRepository.deleteAll();
        String description="A room with two beds and beach view";
        for (int i = 1; i <=20; i++) {
            Room room = new Room(i, "Room with beach view", false, 200.0, description, null,photoRepository.findById("1").orElse(null));
            roomRepositories.save(room);
        }
    }
}
