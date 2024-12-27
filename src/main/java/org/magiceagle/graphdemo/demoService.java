package org.magiceagle.graphdemo;

import org.magiceagle.graphdemo.Entities.User;
import org.magiceagle.graphdemo.Repos.usersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class demoService {

    private final usersRepo usersRepo;

    public demoService(usersRepo centersRepo) {
        this.usersRepo = centersRepo;
    }

    public String getHello() {
        return "Hello";
    }

    public User getUser(User user) {
        return usersRepo.save(user);
    }
}
