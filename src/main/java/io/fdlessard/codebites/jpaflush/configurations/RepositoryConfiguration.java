package io.fdlessard.codebites.jpaflush.configurations;

import io.fdlessard.codebites.jpaflush.repositories.CustomerEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    CustomerEventHandler customerEventHandler() {
        return new CustomerEventHandler();
    }

}
