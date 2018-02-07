package org.mongotutorial.dao;

import org.mongotutorial.dao.basedao.AbstractDAO;
import org.mongotutorial.model.Author;
import org.mongotutorial.model.mapping.Mapper;

public class AuthorDAOImpl extends AbstractDAO<Author> implements AuthorDAO {

    private static final String COLLECTION_NAME = "authors";

    public AuthorDAOImpl(Mapper<Author> mapper) {
        super(mapper);
    }

    @Override
    public Author find(String login, String password) {
        return null;
    }

    @Override
    protected String getCollectionName() {
        return COLLECTION_NAME;
    }
}
