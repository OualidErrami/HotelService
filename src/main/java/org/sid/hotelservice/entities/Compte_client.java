package org.sid.hotelservice.entities;




import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @AllArgsConstructor @NoArgsConstructor
@Document("Compte_client ")
public class Compte_client extends Compte {

    public double facture;
    @Nullable
    public double telephone ;
    @Override
    public ObjectId getId() {
        return super.getId();
    }

    @Override
    public String getNom() {
        return super.getNom();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getPrenom() {
        return super.getPrenom();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getSexe() {
        return super.getSexe();
    }

    @Override
    public void setId(ObjectId id) {
        super.setId(id);
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public void setNom(String nom) {
        super.setNom(nom);
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public void setPrenom(String prenom) {
        super.setPrenom(prenom);
    }

    @Override
    public void setSexe(String sexe) {
        super.setSexe(sexe);
    }

}
