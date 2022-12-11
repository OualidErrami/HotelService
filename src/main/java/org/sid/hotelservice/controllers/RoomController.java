package org.sid.hotelservice.controllers;

import org.sid.hotelservice.entities.Room;
import org.sid.hotelservice.repostories.RoomRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/room")
@CrossOrigin("http://localhost:4200/")
public class RoomController {
    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/getRoom")
    public Room getRoom(){
        Room room=roomRepository.random().getMappedResults().stream().findFirst().orElse(null);
        return room;
    }
}
