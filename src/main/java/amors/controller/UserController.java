package amors.controller;

import amors.entity.User;
import amors.service.api.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {this.userService = userService;}

    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
    public User getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
