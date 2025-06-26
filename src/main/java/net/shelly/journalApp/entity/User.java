package net.shelly.journalApp.entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Getter
//@Setter//also lombok
//@NoArgsConstructor
//@ToString
//@EqualsAndHashCode
//@Builder
@Data//lombok for getters and setters
@Document(collection ="users")
public class User {//pojo class -plane old java object

    @Id//zruri nhi hai but de skti hai
    private ObjectId id;
    @Indexed(unique = true)//for unique username
    @NonNull
    private String userName;
    @NonNull
    private String password;
    @DBRef
    private List<JournalEntry> journalEntries =new ArrayList<>();

    private List <String> roles;//to tell is it user or admin

}
