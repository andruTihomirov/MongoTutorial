package org.mongotutorial.dao;

import org.mongotutorial.dao.basedao.GenericDAO;
import org.mongotutorial.model.Author;

public interface AuthorDAO extends GenericDAO<Author> {

    Author find(String login, String password);

}
