package org.magiceagle.graphdemo.Components;

import org.magiceagle.graphdemo.Entities.Post;
import org.magiceagle.graphdemo.Entities.User;
import org.magiceagle.graphdemo.Repos.PostRepo;
import org.magiceagle.graphdemo.Repos.usersRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class graphController {

    private final usersRepo userRepo;
    private final PostRepo postRepo;

    public graphController(usersRepo userRepo, PostRepo postRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
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

    @QueryMapping
    public List<Post> posts() {
        return postRepo.findAll();
    }

    @QueryMapping
    public Post postById(@Argument  Long id) {
        return postRepo.findById(id).orElse(null);
    }

    @MutationMapping
    public Post createPost(@Argument String title, @Argument String messague) {
        Post post = new Post();
        post.setTitle(title);
        post.setMessague(messague);
        return postRepo.save(post);
    }
}