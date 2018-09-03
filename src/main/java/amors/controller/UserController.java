package amors.controller;

import amors.entity.*;
import amors.service.api.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {this.userService = userService;}

    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
    public User getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
