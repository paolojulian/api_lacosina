package com.lacosina.api.User;

import com.lacosina.api.Profile.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("#oauth2.hasScope('user_info')")
    @PostMapping("/login")
    public String login(
//            @RequestParam(name = "username", defaultValue = "") String username,
//            @RequestParam(name = "password", defaultValue = "") String password
    ) {
        return "Token";
    }

    @PostMapping("/register")
    public User register(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password
    ) {
        return this.userService.createUser(email, username, password);
    }

    @PutMapping("/{id}")
    public Profile updateProfile(
            @RequestParam(name = "id") Integer id,
            @Valid @RequestBody Profile profile
    ) {
        return this.userService.updateProfile(id, profile);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@RequestParam(name = "id") int id) {
        this.userService.deleteUser(id);
    }
}
