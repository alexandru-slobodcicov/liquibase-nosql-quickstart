################################################
# Demo MongoDB
################################################

cd liquibase-mongodb-quickstart/src/main/resources/liquibase || return
# xml format
# Start on a clean DB
liquibase dropAll
# Default file taken from liquibase.properties
liquibase update
# Update manually to true and check the locks
liquibase listLocks
# Release locks
liquibase releaseLocks
# json format
liquibase dropAll
# apply first increment
liquibase --changeLogFile=generic-0-main-1.json update
# check history and status
liquibase --changeLogFile=generic-0-main-2.json history
liquibase --changeLogFile=generic-0-main-2.json status
# apply second increment
liquibase --changeLogFile=generic-0-main-2.json update
# Rollback 3 down
liquibase --changeLogFile=generic-0-main-2.json rollbackCount 3
liquibase --changeLogFile=generic-0-main-2.json rollbackCount 1
liquibase --changeLogFile=generic-0-main-2.json rollbackCount 1

# Custom changes
cd liquibase-nosql-quickstart/liquibase-mongodb-quickstart/target/classes || return
liquibase --defaultsFile=liquibase/liquibase.properties --changeLogFile=liquibase/changelog.custom.xml dropAll
liquibase --defaultsFile=liquibase/liquibase.properties --changeLogFile=liquibase/changelog.custom.xml update

# Or via SpringBoot
mvn clean install
cd liquibase-nosql-quickstart/liquibase-nosql-application/target || return
java -jar liquibase-nosql-application-4.1.1-SNAPSHOT.jar