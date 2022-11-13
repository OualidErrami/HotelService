package org.sid.hotelservice.Auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class AuthenticationResponse {
    public String email;
    public String token;
}
