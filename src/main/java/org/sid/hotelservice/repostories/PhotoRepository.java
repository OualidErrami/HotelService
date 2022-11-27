package org.sid.hotelservice.repostories;

import org.sid.hotelservice.entities.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> {
}
