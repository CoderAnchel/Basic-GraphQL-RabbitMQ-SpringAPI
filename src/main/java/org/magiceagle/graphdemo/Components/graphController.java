package org.magiceagle.graphdemo.Components;

import org.magiceagle.graphdemo.Entities.User;
import org.magiceagle.graphdemo.Repos.usersRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class graphController {

    private final usersRepo userRepo;

    public graphController(usersRepo userRepo) {
        this.userRepo = userRepo;
    }

    @QueryMapping
    public User userById(@Argument  Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @QueryMapping
    public List<User> users() {
        return userRepo.findAll();
    }

    @MutationMapping
    public User createUser(@Argument String name) {
        User user = new User();
        user.setName(name);
        return userRepo.save(user);
    }
}