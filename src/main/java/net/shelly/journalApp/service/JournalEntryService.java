package net.shelly.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import net.shelly.journalApp.entity.JournalEntry;
import net.shelly.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public void saveEntry (JournalEntry journalEntry){
        try {
            journalEntry.setDate(LocalDateTime.now());
            JournalEntryRepository.save(journalEntry);
        } catch (Exception e) {
            log.error("Exception",e);
        }
    }


    public List<JournalEntry> getAll() {

        return JournalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){//??????????????????????optional
        return JournalEntryRepository.findById(id);

    }

    public void deleteById(ObjectId id){
        JournalEntryRepository.deleteById(id);

    }

}
