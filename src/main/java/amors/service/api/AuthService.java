package amors.service.api;

import amors.dto.AuthRequest;
import amors.dto.AuthResponse;

public interface AuthService {
    AuthResponse authenticateUser(AuthRequest authRequest);
}
