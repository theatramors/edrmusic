package amors.controller;

import amors.dto.*;
import amors.service.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {this.authService = authService;}

    @RequestMapping(value = "auth", method = RequestMethod.POST)
    public AuthResponse authenticateUser(@RequestBody AuthRequest authRequest) {
        if (authRequest != null) {
            return authService.authenticateUser(authRequest);
        }
        return new AuthResponse("Authentication failed");
    }
}
