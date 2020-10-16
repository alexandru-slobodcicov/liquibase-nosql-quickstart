package org.liquibase.ext.mongodb.quickstart;

import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import liquibase.executor.ExecutorService;
import liquibase.ext.mongodb.database.MongoConnection;
import liquibase.ext.mongodb.database.MongoLiquibaseDatabase;
import liquibase.ext.mongodb.executor.MongoExecutor;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.springframework.boot.CommandLineRunner;


public class MongoLiquibaseRunner implements CommandLineRunner {

    public void run(final String... args) throws Exception {

        String url = "mongodb://localhost:27017/test_db?socketTimeoutMS=1000&connectTimeoutMS=1000&serverSelectionTimeoutMS=1000";

        // Uncomment To test with 3.10.2
//        MongoConnection connection = new MongoConnection(url);
//        MongoLiquibaseDatabase database = new MongoLiquibaseDatabase();
//        database.setConnection(connection);
//        MongoExecutor executor = new MongoExecutor();
//        executor.setDatabase(database);
//        ExecutorService.getInstance().setExecutor("jdbc", database, executor);

        // Uncomment To test with 4.1.1
        MongoLiquibaseDatabase database = (MongoLiquibaseDatabase) DatabaseFactory.getInstance().openDatabase(url, null, null, null, null);

        Liquibase liquiBase = new Liquibase("liquibase/changelog.create-collection.test.xml", new ClassLoaderResourceAccessor(), database);
        liquiBase.update("");


    }

}
