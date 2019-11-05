package de.plgberlin.info.entities.user;

import de.plgberlin.info.entities.AbstractEntity;
import dev.morphia.annotations.Entity;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Entity(value = "users", noClassnameStored = true)
public class Person extends AbstractEntity {
    private String name;
    private Date geburtstag;
    private String email;
    private ArrayList hobbies;

    public Person(String name, Date geburtstag, String email, ArrayList hobbies){
        this.name = name;
        this.geburtstag = geburtstag;
        this.email = email;
        this.hobbies = hobbies;
    }
}
