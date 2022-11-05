package org.sid.hotelservice.repostories;

import org.sid.hotelservice.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room,Integer> {
}
