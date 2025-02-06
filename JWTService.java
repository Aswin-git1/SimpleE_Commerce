package Simple.E_Commerce.Simple.E_Commerce.SimpleE_CommerceService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JWTService {

    @Value("${aws.jwt.token}")
    private String secretForJwt;


    public String generateToken(String phoneNumber) {
        String jwt = Jwts.builder()
                .setSubject("phoneNumber") // Subject (usually the user ID)
                .setIssuedAt(new Date()) // Token issue date
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, secretForJwt)
                .compact();
        return jwt;
    }
}