package org.mongotutorial.services.baseservice;

import org.bson.types.ObjectId;

import java.util.List;

public interface GenericService<E> {

    E find(ObjectId id);

    List<E> findAll();

    void create(E e);

    void update(E e);

    void delete(ObjectId id);

}
