package uz.pdp.demoproject.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import uz.pdp.demoproject.entity.Role;


import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class JwtUtils {

    private static final String SECRET_KEY = "a2345678a2345678a2345678a2345678a2345678a2345678a2345678a2345678";
    private static final long ACCESS_TOKEN_EXPIRATION_TIME = 1000 * 60 * 60;

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String generateToken(String username, List<Role> roles) {
        List<String> roleNames = roles.stream()
                .map(role -> role.getRoleName().name())
                .toList();
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roleNames)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateRandomToken() {
        return UUID.randomUUID().toString();
    }
}
