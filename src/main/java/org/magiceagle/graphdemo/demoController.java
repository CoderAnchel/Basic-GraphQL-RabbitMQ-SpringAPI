package org.magiceagle.graphdemo;

import org.magiceagle.graphdemo.Entities.User;
import org.magiceagle.graphdemo.rabbit.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:9090")
@RestController
public class demoController {

    @Autowired
    demoService demoService;
    private final RabbitTemplate rabbitTemplate;

    public demoController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @GetMapping("/basic/hello")
    public String hello() {
        return demoService.getHello();
    }

    @PostMapping("/introduce")
    public User putUser(@RequestBody User user) {
        return demoService.getUser(user);
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, message);
        return "Mensaje enviado: " + message;
    }

}
