package org.mongotutorial.model;

import org.bson.types.ObjectId;

public class Comment extends BaseEntity {

    private ObjectId userId;

    private String text;

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
