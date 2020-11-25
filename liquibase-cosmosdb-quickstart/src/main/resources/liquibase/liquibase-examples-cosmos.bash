################################################
# Demo CosmosDB
################################################

# Run on CosmosDB
start_cosmos_emulator.cmd
cd liquibase-cosmosdb-quickstart || return
# Maven Plugin Example
mvn liquibase:dropAll -f pom.xml -Dliquibase.changeLogDirectory=src/main/resources/liquibase -Dliquibase.propertyFile=src/main/resources/liquibase/liquibase.cosmos.properties -Djavax.net.ssl.trustStore="C:\workspace-java\github\certs\cacerts.jks" -Djavax.net.ssl.trustStorePassword=changeit
mvn liquibase:update -f pom.xml -Dliquibase.changeLogDirectory=src/main/resources/liquibase -Dliquibase.propertyFile=src/main/resources/liquibase/liquibase.cosmos.properties -Djavax.net.ssl.trustStore="C:\workspace-java\github\certs\cacerts.jks" -Djavax.net.ssl.trustStorePassword=changeit