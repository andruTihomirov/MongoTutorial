package org.mongotutorial.dao;

import org.bson.types.ObjectId;
import org.mongotutorial.dao.basedao.GenericDAO;
import org.mongotutorial.model.Comment;

public interface CommentDAO extends GenericDAO<Comment> {

    Comment finByPostId(ObjectId id);

}
