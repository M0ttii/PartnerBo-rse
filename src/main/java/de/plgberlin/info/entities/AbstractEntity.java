package de.plgberlin.info.entities;

import dev.morphia.annotations.Id;
import dev.morphia.annotations.PreSave;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;

import java.util.Date;

@ToString
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class AbstractEntity {
    @Id
    @Getter
    private ObjectId id;

    private Date createdAt;
    private Date updatedAt;


    @PreSave
    public void preSave() {
        this.createdAt = createdAt != null ? createdAt : new Date();
        this.updatedAt = new Date();
    }
}
