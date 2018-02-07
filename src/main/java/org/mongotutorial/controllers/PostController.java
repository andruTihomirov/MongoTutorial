package org.mongotutorial.controllers;

import org.bson.types.ObjectId;
import org.mongotutorial.dao.PostDAOImpl;
import org.mongotutorial.model.Post;
import org.mongotutorial.model.mapping.PostMapper;
import org.mongotutorial.services.PostService;
import org.mongotutorial.services.PostServiceImpl;

public class PostController {

    private PostService postService = new PostServiceImpl(new PostDAOImpl(new PostMapper()));

    public void addPostToAuthor(ObjectId authorId, Post post) {
        postService.addPostToAuthor(authorId, post);
    }

}
