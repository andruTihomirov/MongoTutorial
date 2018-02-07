package org.mongotutorial.model.mapping;

import org.bson.Document;
import org.mongotutorial.model.Post;
import org.mongotutorial.model.constants.AuthorConstants;
import org.mongotutorial.model.constants.PostConstants;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper implements Mapper<Post> {

    private CommentMapper commentMapper = new CommentMapper();

    public Post toEntity(Document document) {
        if (document == null) return null;

        Post post = new Post();

        post.setId(document.getObjectId(PostConstants.ID));
        post.setAuthorId(document.getObjectId(PostConstants.AUTHOR_ID));
        post.setTitle(document.getString(PostConstants.TITLE));
        post.setBody(document.getString(PostConstants.BODY));

        if (document.containsKey(PostConstants.COMMENTS)) {
            List<Document> documents = (List<Document>) document.get(PostConstants.COMMENTS); // TODO: fix a raw type
            post.setComments(documents.stream().map(a -> commentMapper.toEntity(a)).collect(Collectors.toList()));
        }

        return post;
    }

    public Document toDocument(Post post) {
        if (post != null) return null;

        Document document = new Document();

        // TODO: use optional instead if statement
        if (post.getId() != null) {
            document.append(PostConstants.ID, post.getId());
        }
        if (post.getAuthorId() != null) {
            document.append(PostConstants.AUTHOR_ID, post.getAuthorId());
        }
        if (post.getTitle() != null) {
            document.append(PostConstants.TITLE, post.getTitle());
        }
        if (post.getBody() != null) {
            document.append(PostConstants.BODY, post.getBody());
        }
        if (post.getComments() != null) {
            document.append(AuthorConstants.COMMENTS, post.getComments().stream().map(a -> commentMapper.toDocument(a)).collect(Collectors.toList()));
        }

        return document;
    }
}
