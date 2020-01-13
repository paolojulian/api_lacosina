package com.lacosina.api.User;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.lacosina.api.Profile.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMutation implements GraphQLMutationResolver {

    @Autowired
    private UserService userService;

    public String login(final String username, final String password) {
        return "Token";
    }

    public User register(
            final String email,
            final String username,
            final String password
    ) {
        return this.userService.createUser(email, username, password);
    }

    public Profile updateProfile(
            final Integer userId,
            final String firstName,
            final String lastName,
            final String handle
    ) {
        return this.userService.updateProfile(
                userId,
                firstName,
                lastName,
                handle
        );
    }

    public Boolean deleteUser(final int id) {
        return this.userService.deleteUser(id);
    }
}
