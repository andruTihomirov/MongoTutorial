package org.mongotutorial.model;

import org.bson.types.ObjectId;

public abstract class BaseEntity {

    private ObjectId id;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

}
