package org.liquibase.ext.mongodb.quickstart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoLiquibaseRunnerConfig {
    @Bean
    public MongoLiquibaseRunner liquibaseRunner() {
        return new MongoLiquibaseRunner();
    }

}
