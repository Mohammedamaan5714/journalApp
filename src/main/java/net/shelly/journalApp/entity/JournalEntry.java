package net.shelly.journalApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

//@Getter
//@Setter//also lombok
//@NoArgsConstructor
//@ToString
//@EqualsAndHashCode
//@Builder
@Data//lombok for getters and setters
@Document(collection ="journal_entries")
<<<<<<< HEAD
@NoArgsConstructor
=======
>>>>>>> f6d407c4bf80b4c5d139e0ec7c343257c674f262
public class JournalEntry {//pojo class -plane old java object

    @Id//zruri nhi hai but de skti hai
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;

}
