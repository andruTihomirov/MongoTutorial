package org.mongotutorial.model.mapping;

import org.bson.Document;
import org.mongotutorial.model.Author;
import org.mongotutorial.model.constants.AuthorConstants;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorMapper implements Mapper<Author> {

    private PostMapper postMapper = new PostMapper();
    private CommentMapper commentMapper = new CommentMapper();

    public Author toEntity(Document document) {
        if (document == null) return null;

        Author author = new Author();
        author.setId(document.getObjectId(AuthorConstants.ID));
        author.setLogin(document.getString(AuthorConstants.LOGIN));
        author.setPassword(document.getString(AuthorConstants.PASSWORD));
        author.setActive(document.getBoolean(AuthorConstants.IS_ACTIVE));

        if (document.containsKey(AuthorConstants.POSTS)) {
            List<Document> documents = (List<Document>) document.get(AuthorConstants.POSTS); // TODO: fix a raw type
            author.setPosts(documents.stream().map(a -> postMapper.toEntity(a)).collect(Collectors.toList()));
        }

        if (document.containsKey(AuthorConstants.COMMENTS)) {
            List<Document> documents = (List<Document>) document.get(AuthorConstants.COMMENTS); // TODO: fix a raw type
            author.setComments(documents.stream().map(a -> commentMapper.toEntity(a)).collect(Collectors.toList()));
        }

        return author;
    }

    public Document toDocument(Author author) {
        if (author == null) return null;

        Document document = new Document();

        // TODO: use optional instead if statement
        if (author.getId() != null) {
            document.append(AuthorConstants.ID, author.getId());
        }
        if (author.getLogin() != null) {
            document.append(AuthorConstants.LOGIN, author.getLogin());
        }
        if (author.getPassword() != null) {
            document.append(AuthorConstants.PASSWORD, author.getPassword());
        }

        document.append(AuthorConstants.IS_ACTIVE, author.isActive());

        if (author.getPosts() != null) {
            document.append(AuthorConstants.POSTS, author.getPosts().stream().map(a -> postMapper.toDocument(a)).collect(Collectors.toList()));
        }
        if (author.getComments() != null) {
            document.append(AuthorConstants.COMMENTS, author.getComments().stream().map(a -> commentMapper.toDocument(a)).collect(Collectors.toList()));
        }

        return document;
    }
}
