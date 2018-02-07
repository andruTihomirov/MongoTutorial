package org.mongotutorial.model.mapping;

import org.bson.Document;

public interface Mapper<E> {

    E toEntity(Document document);

    Document toDocument(E entity);
}
