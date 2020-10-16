## Switch version
Uncomment the wanted version in 
[pom.xml](pom.xml)
[MongoLiquibaseRunner.java](liquibase-mongodb-quickstart/src/main/java/org/liquibase/ext/mongodb/quickstart/MongoLiquibaseRunner.java)


## Build
```shell script
mvn clean install
```

## Run

```shell script
java -jar liquibase-nosql-application/target/liquibase-nosql-application-4.1.1-SNAPSHOT.jar
```