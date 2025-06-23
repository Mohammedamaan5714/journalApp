package net.shelly.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import net.shelly.journalApp.entity.JournalEntry;
import net.shelly.journalApp.entity.User;
import net.shelly.journalApp.repository.JournalEntryRepository;
import net.shelly.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    //ye whi repository hai jo hmne create kri thi but itka kuch implementation nhi kiya tha
    //blke hmne sirf extend kr di thi mongo db ki repository to ye khud hi
    //generat  e kr lega sare funciton jo ke repo me hai
    public void saveEntry (User user){
            userRepository.save(user);
       
    }


    public List<User> getAll() {

        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){//??????????????????????optional
        return userRepository.findById(id);

    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);

    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}
