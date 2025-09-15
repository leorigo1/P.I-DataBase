package leonardo.rigo.backend.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import leonardo.rigo.backend.entities.User;

@Service
public class TokenService {

	@Value("${api.security.token.secret}")
	private String secret;
	
	public String generateToken(User user) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			
			String token = JWT.create()
					.withIssuer("backend")
					.withSubject(user.getEmail())
					.withExpiresAt(this.expirateTime())
					.sign(algorithm);
			return token;
			
		} catch(JWTCreationException e) {
			throw new RuntimeException("Error while autenthication");
		}
	}
	
	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm)
					.withIssuer("backend")
					.build()
					.verify(token)
					.getSubject();
			
		} catch(JWTVerificationException e) {
			return null;
		}
	}
	
	
	private Instant expirateTime( ) {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-3"));
	}
}
