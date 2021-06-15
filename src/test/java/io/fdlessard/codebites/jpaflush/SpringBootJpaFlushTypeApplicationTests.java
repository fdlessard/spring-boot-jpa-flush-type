package io.fdlessard.codebites.jpaflush;

import io.fdlessard.codebites.jpaflush.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootJpaFlushTypeApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void contextLoads() {
    }

}
