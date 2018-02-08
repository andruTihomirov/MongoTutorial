package org.mongotutorial.controllers;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.mongotutorial.dao.AuthorDAO;
import org.mongotutorial.dao.AuthorDAOImpl;
import org.mongotutorial.model.Author;
import org.mongotutorial.model.mapping.AuthorMapper;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AuthorControllerTest {

    private static final String TEST_LOGIN = "andru.tihomirov@gmail.com";
    private static final String TEST_PASSWORD = "0987654321!";
    private static final int AUTHORS_COUNT = 10;
    private static final String UPDATED_LOGIN = "updatedLogin";
    private static final String UPDATED_PASSWORD = "updatedPassword";
    private static final String UNDERSCORE = "_";

    private AuthorController authorController = new AuthorController();
    private AuthorDAO dao = new AuthorDAOImpl(new AuthorMapper());

    @Test
    public void testCreateAndExistAuthor() {
        ObjectId id = authorController.createAuthor(TEST_LOGIN, TEST_PASSWORD);
        assertTrue(authorController.isAuthorExist(id));
        dao.delete(id);
    }

    @Test
    public void testFindAllAuthors() {
        for (int i = 0; i < AUTHORS_COUNT; i++) {
            dao.create(new Author(TEST_LOGIN + UNDERSCORE + i, TEST_PASSWORD + UNDERSCORE + i));
        }

        List<Author> authors = authorController.findAllAuthors();
        assertTrue(authors.size() == AUTHORS_COUNT);

        for (Author author : authors) {
            dao.delete(author.getId());
        }
    }

    @Test
    public void testFindAuthorById() {
        ObjectId id = authorController.createAuthor(TEST_LOGIN, TEST_PASSWORD);
        assertNotNull(dao.find(id));
        dao.delete(id);
    }

    @Test
    public void testUpdateAuthor() {
        ObjectId id = authorController.createAuthor(TEST_LOGIN, TEST_PASSWORD);
        Author author = dao.find(id);
        author.setLogin(UPDATED_LOGIN);
        author.setPassword(UPDATED_PASSWORD);
        authorController.updateAuthor(author);
        author = dao.find(author.getId());

        assertEquals(author.getLogin(), UPDATED_LOGIN);
        assertEquals(author.getPassword(), UPDATED_PASSWORD);

        dao.delete(id);

    }

    @Test
    public void testActivateAuthor() {
        ObjectId id = authorController.createAuthor(TEST_LOGIN, TEST_PASSWORD);
        authorController.activateAuthor(id);
        Author author = authorController.findAuthorById(id);
        assertTrue(author.isActive());
        dao.delete(id);
    }

    @Test
    public void testDeactivateAuthor() {
        ObjectId id = authorController.createAuthor(TEST_LOGIN, TEST_PASSWORD);
        authorController.deactivateAuthor(id);
        Author author = authorController.findAuthorById(id);
        assertFalse(author.isActive());
        dao.delete(id);
    }

    @Test
    public void testDeleteAuthor() {
        ObjectId id = authorController.createAuthor(TEST_LOGIN, TEST_PASSWORD);
        authorController.deleteAuthor(id);
        assertFalse(dao.isExist(id));
    }


}
