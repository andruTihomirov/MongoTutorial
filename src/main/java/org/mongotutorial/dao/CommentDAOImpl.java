package org.mongotutorial.dao;

import org.bson.types.ObjectId;
import org.mongotutorial.dao.basedao.AbstractDAO;
import org.mongotutorial.model.Comment;
import org.mongotutorial.model.mapping.Mapper;

public class CommentDAOImpl extends AbstractDAO<Comment> implements CommentDAO {

    private static final String COLLECTION_NAME = "comments";

    public CommentDAOImpl(Mapper<Comment> mapper) {
        super(mapper);
    }

    @Override
    public Comment finByPostId(ObjectId id) {
        return null;
    }

    @Override
    protected String getCollectionName() {
        return COLLECTION_NAME;
    }
}
