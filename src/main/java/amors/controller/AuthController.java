package amors.controller;

import amors.dto.AuthRequest;
import amors.dto.AuthResponse;
import amors.service.api.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {this.authService = authService;}

    @PostMapping(value = "/auth")
    public AuthResponse authenticateUser(@RequestBody AuthRequest authRequest) {
        if (authRequest != null) {
            return authService.authenticateUser(authRequest);
        }
        return new AuthResponse(true, "Authentication failed");
    }
}
