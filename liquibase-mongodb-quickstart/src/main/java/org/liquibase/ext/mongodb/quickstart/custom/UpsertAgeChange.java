package org.liquibase.ext.mongodb.quickstart.custom;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import liquibase.change.custom.CustomTaskChange;
import liquibase.change.custom.CustomTaskRollback;
import liquibase.database.Database;
import liquibase.exception.CustomChangeException;
import liquibase.exception.RollbackImpossibleException;
import liquibase.exception.SetupException;
import liquibase.exception.ValidationErrors;
import liquibase.ext.mongodb.database.MongoConnection;
import liquibase.resource.ResourceAccessor;
import org.bson.Document;
import org.bson.conversions.Bson;

public class UpsertAgeChange implements CustomTaskChange, CustomTaskRollback {

    private String collectionName;
    private Integer age;

    private ResourceAccessor resourceAccessor;

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public Integer getAge() {
        return age;
    }

    public void execute(final Database database) throws CustomChangeException {
        MongoConnection connection = (MongoConnection) database.getConnection();
        MongoCollection<Document> collection = connection.getMongoDatabase().getCollection(getCollectionName());
        Bson updates = Updates.set("age", getAge());
        Document filter = new Document();
        collection.updateMany(filter, updates);
    }

    public String getConfirmationMessage() {
        return "Age upsert-ed to all";
    }

    public void setUp() throws SetupException {

    }

    public void setFileOpener(ResourceAccessor resourceAccessor) {
        this.resourceAccessor = resourceAccessor;
    }

    public ValidationErrors validate(Database database) {
        return new ValidationErrors();
    }

    public void rollback(Database database) throws CustomChangeException, RollbackImpossibleException {
        //TODO: unset the upsert-ed field. Currently do nothing
    }
}
