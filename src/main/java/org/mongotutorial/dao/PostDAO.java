package org.mongotutorial.dao;

import org.bson.types.ObjectId;
import org.mongotutorial.dao.basedao.GenericDAO;
import org.mongotutorial.model.Post;

public interface PostDAO extends GenericDAO<Post> {

    Post findByAuthorId(ObjectId authorId);

}
