package amors.service.impl;

import amors.dto.*;
import amors.service.api.*;
import org.springframework.stereotype.*;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse authenticateUser(AuthRequest authRequest) {
        return new AuthResponse("hUdshjDHSjsa8943jDSAd9sdaj32FSa", "Authentication success");
    }
}
