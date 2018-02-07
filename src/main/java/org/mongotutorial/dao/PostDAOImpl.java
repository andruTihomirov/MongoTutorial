package org.mongotutorial.dao;

import org.bson.types.ObjectId;
import org.mongotutorial.dao.basedao.AbstractDAO;
import org.mongotutorial.model.Post;
import org.mongotutorial.model.mapping.Mapper;

public class PostDAOImpl extends AbstractDAO<Post> implements PostDAO  {

    private static final String COLLECTION_NAME = "posts";

    public PostDAOImpl(Mapper<Post> mapper) {
        super(mapper);
    }

    @Override
    public Post findByAuthorId(ObjectId authorId) {
        return null;
    }

    @Override
    protected String getCollectionName() {
        return COLLECTION_NAME;
    }
}
