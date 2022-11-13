package org.sid.hotelservice.Auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Service
public class JwtUtils {
    private static final String SECRET_KEY="ke3a8d5";


    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims=new HashMap<>();
        return createToken(claims,userDetails.getUsername());
    }

    public Boolean validateToken(String token,UserDetails userDetails){
        String username =extractUsername(token);
        return username.equals(userDetails.getUsername()) && isTokenExpired(token);
}

    private String createToken(Map<String,Object>claims,String subject){
        Date now =new Date(System.currentTimeMillis());
        Date until=new Date(System.currentTimeMillis()+1000*60*60*10);
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(now).setExpiration(until)
            .signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        Claims x = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return x;
    }
    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }

    public Date extractExpirationDate(String token){
        Date x =extractClaim(token,Claims::getExpiration);
        return x;
    }
    private Boolean isTokenExpired(String token){
         Boolean x = extractExpirationDate(token).after(new Date());
        return x;
    }
}