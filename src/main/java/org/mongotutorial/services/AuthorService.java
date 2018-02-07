package org.mongotutorial.services;

import org.bson.types.ObjectId;
import org.mongotutorial.model.Author;
import org.mongotutorial.services.baseservice.GenericService;

public interface AuthorService extends GenericService<Author> {

    void deactivateAuthor(ObjectId id);

    void activateAuthor(ObjectId id);

}
