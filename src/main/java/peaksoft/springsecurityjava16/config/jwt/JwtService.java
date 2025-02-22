package peaksoft.springsecurityjava16.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import peaksoft.springsecurityjava16.entities.User;
import peaksoft.springsecurityjava16.repositories.UserRepo;

import java.time.ZonedDateTime;

@Component
public class JwtService {
    @Value("${security.secret.key}")
    private String secretKey;
    private final UserRepo userRepo;

    public JwtService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public String generateToken(User user){
        ZonedDateTime now = ZonedDateTime.now();
        return JWT.create()
                .withClaim("id", user.getId())
                .withClaim("email", user.getEmail())
                .withClaim("role", user.getRole())
                .withIssuedAt(now.toInstant())
                .withExpiresAt(now.plusSeconds(100000000).toInstant())
                .sign(getAlgorithm());
    }

    public User verifyToken(String token){
        Algorithm algorithm = getAlgorithm();
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String email = decodedJWT.getClaim("email").asString();
        return userRepo.findUserByEmail(email).orElseThrow(
                () -> new RuntimeException("User not found with email: " + email)
        );
    }

    public Algorithm getAlgorithm(){
        return Algorithm.HMAC256(secretKey);
    }
}
