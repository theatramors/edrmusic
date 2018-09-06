package amors.service.api;

import amors.entity.User;

public interface UserService {
    User findByUsername(String username);
}
