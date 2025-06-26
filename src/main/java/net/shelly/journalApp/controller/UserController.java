package net.shelly.journalApp.controller;

import net.shelly.journalApp.entity.JournalEntry;
import net.shelly.journalApp.entity.User;
import net.shelly.journalApp.service.JournalEntryService;
import net.shelly.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user ){
        userService.saveEntry(user);
    }

    @PutMapping("/{userName}")//alsi hai try catch nhi lgya abhi yad rakhna
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String userName){
        User userInDb = userService.findByUserName(userName);
        if (userInDb != null){
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //delete user add krna hai

}
