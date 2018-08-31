package amors.service.impl;

import amors.entity.User;
import amors.repository.UserRepository;
import amors.service.api.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
