package org.sid.hotelservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Document("Reservation")
public class Reservation {
    @Id
    public ObjectId id;
    @DBRef
    private Room room;
    @DBRef
    private Compte_client client;
    public String dateDeReservation;
    public Date dateDeDebut;
    public Date DateDeFin;
}
