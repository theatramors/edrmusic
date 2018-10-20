package amors.service.impl;

import amors.dto.AuthRequest;
import amors.dto.AuthResponse;
import amors.entity.User;
import amors.service.api.AuthService;
import amors.service.api.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserService userService;

    private Map<Long, ValidatedUserToken> tokens = new ConcurrentHashMap<>();

    @Autowired
    public AuthServiceImpl(UserService userService) {this.userService = userService;}

    @Override
    public AuthResponse authenticateUser(AuthRequest authRequest) {
        if (authRequest.getUsername() == null) {
            return new AuthResponse(true, "Authentication failed");
        }
        User user = userService.findByUsername(authRequest.getUsername());
        if (user != null && matchesPass(authRequest, user)) {
            String token = generateToken(user);
            tokens.put(user.getId(), new ValidatedUserToken(token));
            System.out.println("Tokens in safe: " + tokens.size());
            return new AuthResponse(token, false, "Authentication success");
        }
        return new AuthResponse(true, "Invalid username");
    }

    private Boolean matchesPass(AuthRequest authRequest, User user) {
        return authRequest.getPassword().equals(user.getPassword());
    }

    private String generateToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("id", user.getId());
        claims.put("login", user.getUsername());
        claims.setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000));

        // TODO Replace deprecated method
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "secret").compact();
    }

    private static class ValidatedUserToken {
        private final String value;
        private final Boolean valid = true;

        private ValidatedUserToken(String value) {this.value = value;}
    }
}
