package de.plgberlin.info.repositories;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import de.plgberlin.info.entities.user.Person;
import de.plgberlin.info.utils.MongoConstants;
import dev.morphia.Datastore;

import java.util.ArrayList;
import java.util.Date;

public class PersonRepository extends Repository<Person> {
    @Inject
    protected PersonRepository(@Named(MongoConstants.AbuseSystem_DATASTORE) Datastore datastore) {
        super(Person.class, datastore);
    }


    public Person findByName(String name) {
        return this.createQuery()
                .field("name").equal(name)
                .get();
    }

    public Person erstellePerson(String name, Date geburtstag, String email, ArrayList hobbies) {
        Person person = new Person();
        person.setEmail(email);
        person.setGeburtstag(geburtstag);
        person.setName(name);
        person.setHobbies(hobbies);
        getDatastore().save(person);
        return person;
    }

    public boolean hatHobby(String name, String hobby){
        if(this.findByName(name).getHobbies().contains(hobby)){
            return true;
        }
        return false;
    }

    public Person[] findeDurchHobby(String hobby){
        return new Person[]{this.createQuery()
                .field("hobby").equal(hobby)
                .get()};
    }
}

