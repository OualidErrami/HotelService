package org.sid.hotelservice.repostories;

import org.bson.types.ObjectId;
import org.sid.hotelservice.entities.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<Reservation, ObjectId> {

}
