package org.sid.hotelservice.repostories;

import org.bson.types.ObjectId;
import org.sid.hotelservice.entities.Compte;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200/")

public interface CompteRepository extends MongoRepository<Compte, ObjectId> {
}