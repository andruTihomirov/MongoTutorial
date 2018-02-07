package org.mongotutorial.controllers;

import org.mongotutorial.model.Author;

import java.util.List;

public class AuthorControllerCases {

    public static void main(String[] args) throws Exception {
        AuthorController authorController = new AuthorController();

        authorController.createAuthor("andru.tihomirov@gmail.com", "0987654321!");

        List<Author> authors = authorController.findAllAuthors();

        if (authors == null) throw new Exception("Authors does't exist");

        authors.forEach(System.out::println);

        Author author = authorController.findAuthorById(authors.get(0).getId());
        System.out.println("Login: [" + author.getLogin() + "] Password: " + author.getPassword());

        author.setLogin("ivan.ivanov@gmail.com");
        author.setPassword("!V@noV_77");
        authorController.updateAuthor(author);

        authorController.activateAuthor(author.getId());

        authorController.deactivateAuthor(author.getId());

        // TODO: check if the author exists
        authorController.deleteAuthor(author.getId());

    }

}
