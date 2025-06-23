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
@NoArgsConstructor
public class JournalEntry {//pojo class -plane old java object

    @Id//zruri nhi hai but de skti hai
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;

}
