package org.sid.hotelservice.entities;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.index.CompoundIndex;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data @NoArgsConstructor @AllArgsConstructor
@CompoundIndex(def = "{'email':1}",unique = true)
public abstract class Compte {
    @Id
    public ObjectId id;
    public String nom;
    public  String prenom;
    @NonNull @Email @NotEmpty
    public String email;
    @NonNull @Size(min = 8,message = "too short")@NotEmpty
    public String password;
    public String sexe;
}
