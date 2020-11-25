package org.liquibase.ext.quickstart.mongodb;

import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import liquibase.exception.LiquibaseException;
import liquibase.ext.mongodb.database.MongoLiquibaseDatabase;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class LiquibaseCosmosIntegrationTest {

    public static final String URL = "mongodb://localhost:C2y6yDjf5%2FR%2Bob0N8A7Cgv30VRDJIWEHLM%2B4QDU5DE2nQ9nDuVTqobD4b8mGGyPMbIZnqyMsEcaGQy67XIw%2FJw%3D%3D@localhost:10255/mongo?ssl=true";

    @Test
    @Disabled
    void testMongoLiquibaseOnCosmos() throws LiquibaseException {
        MongoLiquibaseDatabase database = (MongoLiquibaseDatabase) DatabaseFactory.getInstance().openDatabase(URL, null, null, null , new ClassLoaderResourceAccessor());

        Liquibase liquiBase = new Liquibase("liquibase/cosmos-insert-people.json", new ClassLoaderResourceAccessor(), database);
        liquiBase.update("");
    }

    @Test
    @Disabled
    void testMongoLiquibaseOnCosmosDropAll() throws LiquibaseException {
        MongoLiquibaseDatabase database = (MongoLiquibaseDatabase) DatabaseFactory.getInstance().openDatabase(URL, null, null, null , new ClassLoaderResourceAccessor());

        Liquibase liquiBase = new Liquibase("liquibase/cosmos-insert-people.json", new ClassLoaderResourceAccessor(), database);
        liquiBase.dropAll();
    }

}
