package org.mongotutorial.services.baseservice;

import org.bson.types.ObjectId;
import org.mongotutorial.dao.basedao.GenericDAO;

import java.util.List;

public abstract class AbstractService<E, DAO extends GenericDAO<E>> implements GenericService<E> {

    protected DAO dao;

    public AbstractService(DAO dao) {
        this.dao = dao;
    }

    @Override
    public E find(ObjectId id) {
        return dao.find(id);
    }

    @Override
    public List<E> findAll() {
        return dao.findAll();
    }

    @Override
    public ObjectId create(E e) {
        return dao.create(e);
    }

    @Override
    public void update(E e) {
        dao.update(e);
    }

    @Override
    public void delete(ObjectId id) {
        dao.delete(id);
    }

    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }
}
