//package net.shelly.journalApp.controller;
//
//import net.shelly.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryController {
//
//    private Map<String, JournalEntry> journalEntries =new HashMap<>();
//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public Boolean createEntry(@RequestBody JournalEntry myEntry){
//        journalEntries.put(myEntry.getId(), myEntry);
//        return true;
//
//    }
//
//    @GetMapping("/id/{myid}")
//    public JournalEntry getJournalById(@PathVariable String myid){
//        return journalEntries.get(myid);
//    }
//
//    @DeleteMapping("id/{myid}")
//    public JournalEntry deleteJournalById(@PathVariable Long myid){
//        return journalEntries.remove(myid);
//    }
//    @PutMapping("/id/{myid}")
//    public JournalEntry updateJournalById(@PathVariable String myid,@RequestBody JournalEntry myEntry){
//        return journalEntries.put(myid,myEntry);
//    }
//}
