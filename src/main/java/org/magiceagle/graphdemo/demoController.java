package org.magiceagle.graphdemo;

import org.magiceagle.graphdemo.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController {

    @Autowired
    demoService demoService;

    @GetMapping("/basic")
    public String hello() {
        return demoService.getHello();
    }

    @PostMapping("/introduce")
    public User putUser(@RequestBody User user) {
        return demoService.getUser(user);
    }

}
