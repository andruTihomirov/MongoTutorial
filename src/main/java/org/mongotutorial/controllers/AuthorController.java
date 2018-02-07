package org.mongotutorial.controllers;

import org.bson.types.ObjectId;
import org.mongotutorial.dao.AuthorDAOImpl;
import org.mongotutorial.model.Author;
import org.mongotutorial.model.mapping.AuthorMapper;
import org.mongotutorial.services.AuthorService;
import org.mongotutorial.services.AuthorServiceImpl;

import java.util.List;

public class AuthorController {

    private AuthorService authorService = new AuthorServiceImpl(new AuthorDAOImpl(new AuthorMapper()));

    public void createAuthor(String login, String password) {
        Author author = new Author(login, password);
        authorService.create(author);
    }

    public List<Author> findAllAuthors() {
        return authorService.findAll();
    }

    public Author findAuthorById(ObjectId id) {
        return authorService.find(id);
    }

    public void updateAuthor(Author author) {
        authorService.update(author);
    }

    public void activateAuthor(ObjectId id) {
        authorService.activateAuthor(id);
    }

    public void deactivateAuthor(ObjectId id) {
        authorService.deactivateAuthor(id);
    }

    public void deleteAuthor(ObjectId id) {
        authorService.delete(id);
    }

}
