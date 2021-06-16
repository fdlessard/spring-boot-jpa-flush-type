package io.fdlessard.codebites.jpaflush.repositories;


import io.fdlessard.codebites.jpaflush.model.Customer;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@RepositoryEventHandler
public class CustomerEventHandler {

  @Autowired
  private CustomerRepository customerRepository;

  @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
  @HandleAfterCreate
  public void handleAfterCreate(Customer customer) {
    logger.info("CustomerEventHandler.handleAfterCreate() - customer : {}", customer);
    Customer savedCustomer = customerRepository.findCustomerById(customer.getId());
    logger.info("CustomerEventHandler.handleAfterCreate() - savedCustomer - findCustomerById: {}",
        savedCustomer);
    String aliasId = customerRepository.getAliasId(customer.getId());
    logger.info("CustomerEventHandler.handleAfterCreate() - getAliasId: {}", aliasId);
    Optional<Customer> optional = customerRepository.findById(customer.getId());
    logger.info("CustomerEventHandler.handleAfterCreate() - savedCustomer - findById: {}",
        optional.get());
    savedCustomer = customerRepository.findByIdNamedQuery(customer.getId());
    logger.info("CustomerEventHandler.handleAfterCreate() - savedCustomer - findByIdNamedQuery: {}",
        savedCustomer);

  }

  @HandleAfterSave
  public void handleAfterSave(Customer customer) {
    logger.info("CustomerEventHandler.handleAfterSave() - customer : {}", customer);
    Customer updatedCustomer = customerRepository.findCustomerById(customer.getId());
    logger.info("CustomerEventHandler.handleAfterSave() - updatedCustomer - findCustomerById: {}",
        updatedCustomer);
    Optional<Customer> optional = customerRepository.findById(customer.getId());
    logger.info("CustomerEventHandler.handleAfterSave() - updatedCustomer - findById: {}",
        optional.get());
  }
}
