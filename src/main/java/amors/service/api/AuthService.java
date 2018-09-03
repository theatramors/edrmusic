package amors.service.api;

import amors.dto.*;

public interface AuthService {
    AuthResponse authenticateUser(AuthRequest authRequest);
}
