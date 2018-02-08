package org.mongotutorial.services;

import org.bson.types.ObjectId;
import org.mongotutorial.dao.AuthorDAO;
import org.mongotutorial.model.Author;
import org.mongotutorial.services.baseservice.AbstractService;

public class AuthorServiceImpl extends AbstractService<Author, AuthorDAO> implements AuthorService {

    public AuthorServiceImpl(AuthorDAO dao) {
        super(dao);
    }

    @Override
    public void deactivateAuthor(ObjectId id) {
        Author author = dao.find(id);
        author.setActive(false);
        dao.update(author);
    }

    @Override
    public void activateAuthor(ObjectId id) {
        Author author = dao.find(id);
        author.setActive(true);
        dao.update(author);
    }

    @Override
    public boolean isExist(ObjectId id) {
        return dao.isExist(id);
    }
}
