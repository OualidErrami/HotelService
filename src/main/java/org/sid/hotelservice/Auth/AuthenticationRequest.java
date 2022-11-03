package org.sid.hotelservice.Auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.hotelservice.entities.Compte_client;

@Data @AllArgsConstructor @NoArgsConstructor
public class AuthenticationRequest  {
    public String email;
    public String password;
}
