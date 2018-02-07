package org.mongotutorial.dao.basedao;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.List;

public interface GenericDAO<E> {

    E find(ObjectId id);

    List<E> findMany(Bson filter);

    List<E> findAll();

    void create(E e);

    void update(E e);

    void delete(ObjectId id);

    boolean isExist(ObjectId id);

}
