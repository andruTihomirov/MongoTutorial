package org.mongotutorial.dao.basedao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.mongotutorial.model.BaseEntity;
import org.mongotutorial.model.constants.BaseConstants;
import org.mongotutorial.model.mapping.Mapper;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public abstract class AbstractDAO<E extends BaseEntity> implements GenericDAO<E> {

    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String DATABASE_NAME = "posts_portal";

    private MongoDatabase mongoDatabase;

    protected MongoCollection<Document> collection;

    private Mapper<E> mapper;

    public AbstractDAO(Mapper<E> mapper) {
        this.mapper = mapper;
        MongoClient mongoClient = new MongoClient(HOST, PORT);
        mongoDatabase = mongoClient.getDatabase(DATABASE_NAME);
        collection = mongoDatabase.getCollection(getCollectionName());
    }

    @Override
    public E find(ObjectId id) {
        return collection.find(eq(id)).map(mapper::toEntity).first();
    }

    @Override
    public List<E> findMany(Bson filter) {
        return null;
    }

    @Override
    public List<E> findAll() {
        return collection.find().map(mapper::toEntity).into(new ArrayList<>());
    }

    @Override
    public ObjectId create(E e) {
        Document document = mapper.toDocument(e);
        collection.insertOne(document);
        return document.getObjectId(BaseConstants.ID);
    }

    @Override
    public void update(E e) {
        Document document = new Document("$set", mapper.toDocument(e));
        Bson where = eq(e.getId());
        collection.findOneAndUpdate(where, document);
    }

    @Override
    public void delete(ObjectId id) {
        collection.deleteOne(eq(id));
    }

    @Override
    public boolean isExist(ObjectId id) {
        return collection.count(eq(id)) > 0;
    }

    protected abstract String getCollectionName();

}
