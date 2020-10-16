package org.liquibase.ext.quickstart;

import org.liquibase.ext.mongodb.quickstart.MongoLiquibaseRunnerConfig;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(MongoLiquibaseRunnerConfig.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
