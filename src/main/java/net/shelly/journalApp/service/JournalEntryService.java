package net.shelly.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import net.shelly.journalApp.entity.JournalEntry;
import net.shelly.journalApp.entity.User;
import net.shelly.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository JournalEntryRepository;
    //ye whi repository hai jo hmne create kri thi but itka kuch implementation nhi kiya tha
    //blke hmne sirf extend kr di thi mongo db ki repository to ye khud hi
    //generate kr lega sare funciton jo ke repo me hai

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry (JournalEntry journalEntry, String userName){
        try {

            User user =userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = JournalEntryRepository.save(journalEntry);//isse jo entry save hui thi wo entry meko mil jyegi isse saved me
            user.getJournalEntries().add(saved);
            userService.saveEntry(user);

        } catch (Exception e) {
            log.error("Exception",e);
            throw new RuntimeException("something went wrong with the save entry",e);
        }
    }
    public void saveEntry (JournalEntry journalEntry){

        JournalEntryRepository.save(journalEntry);

    }


    public List<JournalEntry> getAll() {

        return JournalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){//??????????????????????optional
        return JournalEntryRepository.findById(id);

    }

    public void deleteById(ObjectId id, String userName){
        User user =userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x->x.getId().equals(id));
        userService.saveEntry(user);//same id pe save chalate hai to update ho jata hai mongodb me
        JournalEntryRepository.deleteById(id);

    }

}
