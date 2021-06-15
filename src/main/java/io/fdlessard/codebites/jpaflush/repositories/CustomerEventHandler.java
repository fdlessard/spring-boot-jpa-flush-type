package io.fdlessard.codebites.jpaflush.repositories;

import io.fdlessard.codebites.jpaflush.model.Customer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.util.Optional;

@Slf4j
@RepositoryEventHandler
public class CustomerEventHandler {

    @Autowired
    private CustomerRepository customerRepository;

    @HandleAfterCreate
    public void handleAfterCreate(Customer customer) {
        logger.info("CustomerEventHandler.handleAfterCreate() - customer : {}", customer);
        Optional<Customer> optional = customerRepository.findById(customer.getId());
        logger.info("CustomerEventHandler.handleAfterCreate() - savedCustomer : {}", optional.get());

    }

    @HandleAfterSave
    public void handleAfterSave(Customer customer) {
        logger.info("CustomerEventHandler.handleAfterSave() - customer : {}", customer);
        Optional<Customer> optional = customerRepository.findById(customer.getId());
        logger.info("CustomerEventHandler.handleAfterCreate() - updatedCustomer : {}", optional.get());
    }

}
