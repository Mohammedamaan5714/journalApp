package net.shelly.journalApp.controller;

import net.shelly.journalApp.entity.JournalEntry;
import net.shelly.journalApp.entity.User;
import net.shelly.journalApp.service.JournalEntryService;
import net.shelly.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    UserService userService;

    @Autowired
    private JournalEntryService journalEntryService;//to use service object as bean

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<JournalEntry> all = journalEntryService.getAll();
        if (all !=null & !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("{userName}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName){
        User user =userService.findByUserName(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if (all !=null & !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("{userName}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry,@PathVariable String userName){

        try {
            journalEntryService.saveEntry(myEntry,userName);
            return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{myid}")
    public ResponseEntity<JournalEntry>  getJournalById(@PathVariable ObjectId myid){
        Optional<JournalEntry> journalEntry = journalEntryService.findById(myid);
        if (journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("id/{userName}/{myid}")
    public ResponseEntity<?> deleteJournalById(@PathVariable ObjectId myid, @PathVariable String userName){
        journalEntryService.deleteById(myid,userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/id/{myid}")
    public ResponseEntity<?> updateJournalById(@PathVariable ObjectId myid,@RequestBody JournalEntry newEntry){
        JournalEntry old = journalEntryService.findById(myid).orElse(null);
        if (old!=null){
            old.setTitle(newEntry.getTitle() !=null && !newEntry.getTitle().equals("")? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() !=null && ! newEntry.getContent().equals("")? newEntry.getContent() : old.getContent());
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        journalEntryService.saveEntry(old);
//        return old;
    }
}
