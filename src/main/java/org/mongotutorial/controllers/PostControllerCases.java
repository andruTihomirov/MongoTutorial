package org.mongotutorial.controllers;

import org.mongotutorial.model.Author;
import org.mongotutorial.model.Post;

import java.util.List;

public class PostControllerCases {

    public static void main(String[] args) throws Exception {
        AuthorController authorController = new AuthorController();
        PostController postController = new PostController();

        List<Author> authors = authorController.findAllAuthors();

        if (authors == null) throw new Exception("Authors does't exist");

        Author author = authors.get(0);
        Post post = new Post();
        post.setTitle("New Post");
        post.setBody("This is my new post!");
        postController.addPostToAuthor(author.getId(), post);
    }

}
