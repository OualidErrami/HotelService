package org.sid.hotelservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Data @AllArgsConstructor @NoArgsConstructor
@Document("Reservation")
public class Reservation {
    @Id
    public ObjectId id;
    @DBRef
    private Room room;
    @DBRef @Indexed
    private Compte_client client;
    @NotEmpty
    public String dateDeReservation;
    @NotEmpty
    public String dateDeDebut;
    @NotEmpty
    public String DateDeFin;
}
