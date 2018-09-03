package amors.service.impl;

import amors.entity.*;
import amors.repository.*;
import amors.service.api.*;
import org.springframework.stereotype.*;

import javax.transaction.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
