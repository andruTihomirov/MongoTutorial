package org.mongotutorial.services;

import org.bson.types.ObjectId;
import org.mongotutorial.dao.CommentDAO;
import org.mongotutorial.model.Comment;
import org.mongotutorial.services.baseservice.AbstractService;

import java.util.List;

public class CommentServiceImpl extends AbstractService<Comment, CommentDAO> implements CommentService {

    public CommentServiceImpl(CommentDAO dao) {
        super(dao);
    }

    @Override
    public List<Comment> findCommentsByAuthorId(ObjectId authorId) {
        return null;
    }

    @Override
    public List<Comment> findCommentsByPostId(ObjectId postId) {
        return null;
    }
}
