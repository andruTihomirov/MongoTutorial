package org.mongotutorial.services;

import org.bson.types.ObjectId;
import org.mongotutorial.dao.PostDAO;
import org.mongotutorial.model.Post;
import org.mongotutorial.services.baseservice.AbstractService;

import java.util.List;

public class PostServiceImpl extends AbstractService<Post, PostDAO> implements PostService {

    public PostServiceImpl(PostDAO dao) {
        super(dao);
    }

    @Override
    public void addPostToAuthor(ObjectId authorId, Post post) {

    }

    @Override
    public List<Post> findPostsByAuthorId(ObjectId authorId) {
        return null;
    }

    @Override
    public Post findPostByTitle(String title) {
        return null;
    }
}
