package org.sid.hotelservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class Photo {
    @Transient
    public static final String SEQUENCE_NAME="PhotoSequence";
    @Id
    public String _id;
    public String title;
    public Binary image;

    public Photo(String title) {
        this.title=title;
    }
}
