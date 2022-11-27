package org.sid.hotelservice.Init;

import org.sid.hotelservice.entities.Room;
import org.sid.hotelservice.repostories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RoomInit {
   @Autowired
    private RoomRepository roomRepostories;

    @PostConstruct
    public void createRooms() {
        roomRepostories.deleteAll();
        for (int i = 1; i <=19; i++) {
            Room room = new Room(i, true, 200.0, "room with beach view",null);
            roomRepostories.save(room);
        }
            Room room = new Room(20, false, 200.0, "room with beach view",null);
            roomRepostories.save(room);

    }
}
