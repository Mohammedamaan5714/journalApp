package net.shelly.journalApp.repository;

import net.shelly.journalApp.entity.JournalEntry;
import net.shelly.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String userName);
}
