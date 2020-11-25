package org.liquibase.ext.quickstart.cosmosdb;

import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import liquibase.exception.LiquibaseException;
import liquibase.ext.cosmosdb.database.CosmosLiquibaseDatabase;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class LiquibaseCosmosIntegrationTest {

    public static final String URL = "cosmosdb://localhost:C2y6yDjf5/R+ob0N8A7Cgv30VRDJIWEHLM+4QDU5DE2nQ9nDuVTqobD4b8mGGyPMbIZnqyMsEcaGQy67XIw/Jw==@localhost:8081/testdb1";

    @Test
    @Disabled
    void testCosmosLiquibaseOnCosmos() throws LiquibaseException {
        CosmosLiquibaseDatabase database = (CosmosLiquibaseDatabase) DatabaseFactory.getInstance().openDatabase(URL, null, null, null , new ClassLoaderResourceAccessor());

        Liquibase liquiBase = new Liquibase("liquibase/changelog.cosmos-generic-1.xml", new ClassLoaderResourceAccessor(), database);
        liquiBase.update("");
    }

    @Test
    @Disabled
    void testCosmosLiquibaseOnCosmosDropAll() throws LiquibaseException {
        CosmosLiquibaseDatabase database = (CosmosLiquibaseDatabase) DatabaseFactory.getInstance().openDatabase(URL, null, null, null , new ClassLoaderResourceAccessor());

        Liquibase liquiBase = new Liquibase("liquibase/changelog.cosmos-generic-1.xml", new ClassLoaderResourceAccessor(), database);
        liquiBase.dropAll();
    }

}
