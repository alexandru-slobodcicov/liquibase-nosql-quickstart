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

    /**
     * Method called to run the change logic.
     *
     * @param database
     * @throws CustomChangeException an exception occurs while processing this change
     */
    public void execute(final Database database) throws CustomChangeException {
        MongoConnection connection = (MongoConnection) database.getConnection();
        MongoCollection<Document> collection = connection.getMongoDatabase().getCollection(getCollectionName());
        Bson updates = Updates.set("age", getAge());
        Document filter = new Document();
        collection.updateMany(filter, updates);
    }

    /**
     * Confirmation message to be displayed after the change is executed
     *
     * @return a {@link String} containing the message after the change is executed
     */
    public String getConfirmationMessage() {
        return "Age upsert-ed to all";
    }

    /**
     * This method will be called after the no arg constructor and all of the
     * properties have been set to allow the task to do any heavy tasks or
     * more importantly generate any exceptions to report to the user about
     * the settings provided.
     */
    public void setUp() throws SetupException {

    }

    /**
     * Sets the fileOpener that should be used for any file loading and resource
     * finding for files that are provided by the user.
     *
     * @param resourceAccessor
     */
    public void setFileOpener(ResourceAccessor resourceAccessor) {
        this.resourceAccessor = resourceAccessor;
    }

    /**
     * Tests that the change is configured correctly before attempting to execute it.
     *
     * @param database The database the change will be ran against
     */
    public ValidationErrors validate(Database database) {
        return new ValidationErrors();
    }

    /**
     * Method called to rollback the change.
     *
     * @param database Database the change is being executed against.
     * @throws CustomChangeException       an exception occurs while processing this rollback
     * @throws RollbackImpossibleException if rollback is not supported for this change
     */
    public void rollback(Database database) throws CustomChangeException, RollbackImpossibleException {
        //TODO: unset the upsert-ed field. Currently do nothing
    }
}
