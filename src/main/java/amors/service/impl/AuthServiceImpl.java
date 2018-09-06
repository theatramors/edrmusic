package amors.service.impl;

import amors.dto.AuthRequest;
import amors.dto.AuthResponse;
import amors.service.api.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse authenticateUser(AuthRequest authRequest) {
        return new AuthResponse("hUdshjDHSjsa8943jDSAd9sdaj32FSa", "Authentication success");
    }
}
