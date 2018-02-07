package org.mongotutorial.services;

import org.bson.types.ObjectId;
import org.mongotutorial.model.Post;
import org.mongotutorial.services.baseservice.GenericService;

import java.util.List;

public interface PostService extends GenericService<Post> {

    void addPostToAuthor(ObjectId authorId, Post post);

    List<Post> findPostsByAuthorId(ObjectId authorId);

    Post findPostByTitle(String title);

}
