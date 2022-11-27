package org.sid.hotelservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @AllArgsConstructor @NoArgsConstructor
@Document("Room")
public class Room {
    @Id
    public Integer id;
    public Boolean state;
    public double price;
    public String description;
    @DBRef @Indexed
    public Reservation reservation;
}
