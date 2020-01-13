package com.lacosina.api.User;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserQuery implements GraphQLQueryResolver {

    @Autowired
    private UserService userService;

    public List<User> getUsers(final int limitCount) {
        return this.userService.getUserList(limitCount);
    }

    public Optional<User> getUser(final int id) {
        return this.userService.getUser(id);
    }
}
