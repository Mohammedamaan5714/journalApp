package net.shelly.journalApp.controller;

import net.shelly.journalApp.entity.User;
import net.shelly.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user ){
        userService.saveNewUser(user);
    }

     @GetMapping("/health-check")
    public String healthCheck(){
        return "ok-running";
    }
}
