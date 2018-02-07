package org.mongotutorial.model.mapping;

import org.bson.Document;
import org.mongotutorial.model.Comment;
import org.mongotutorial.model.constants.CommentConstants;

public class CommentMapper implements Mapper<Comment> {

    @Override
    public Comment toEntity(Document document) {
        if (document == null) return null;

        Comment comment = new Comment();

        comment.setId(document.getObjectId(CommentConstants.ID));
        comment.setUserId(document.getObjectId(CommentConstants.USER_ID));
        comment.setUserId(document.getObjectId(CommentConstants.TEXT));

        return comment;
    }

    @Override
    public Document toDocument(Comment comment) {
        if (comment == null) return null;

        Document document = new Document();

        // TODO: use optional instead if statement
        if (comment.getId() != null) {
            document.append(CommentConstants.ID, comment.getId());
        }

        if (comment.getUserId() != null) {
            document.append(CommentConstants.USER_ID, comment.getUserId());
        }

        if (comment.getText() != null) {
            document.append(CommentConstants.TEXT, comment.getText());
        }

        return document;
    }
}
