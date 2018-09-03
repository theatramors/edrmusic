package amors.service.api;

import amors.entity.*;

public interface UserService {
    User findByUsername(String username);
}
