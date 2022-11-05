package org.sid.hotelservice.repostories;

import org.bson.types.ObjectId;
import org.sid.hotelservice.entities.Reclamation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReclamationRepository extends MongoRepository<Reclamation, ObjectId> {
}
