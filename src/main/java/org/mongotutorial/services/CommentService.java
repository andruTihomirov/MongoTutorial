package org.mongotutorial.services;

import org.bson.types.ObjectId;
import org.mongotutorial.model.Comment;
import org.mongotutorial.services.baseservice.GenericService;

import java.util.List;

public interface CommentService extends GenericService<Comment> {

    List<Comment> findCommentsByAuthorId(ObjectId authorId);

    List<Comment> findCommentsByPostId(ObjectId postId);
}
