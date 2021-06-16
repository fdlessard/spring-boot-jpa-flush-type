package io.fdlessard.codebites.jpaflush.repositories;


import io.fdlessard.codebites.jpaflush.model.Customer;
import java.util.Optional;
import javax.persistence.QueryHint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "customers")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    Page<Customer> findByLastName(@Param("lastName") String lastName, Pageable p);

    Page<Customer> findByFirstName(@Param("firstName") String firstName, Pageable p);

    @QueryHints(
        value = {
            @QueryHint(
                name = org.hibernate.annotations.QueryHints.FLUSH_MODE,
                value = "ALWAYS"
            )
        }
        )
    @Query(
        value = "select * from customer where id=?",
        nativeQuery = true
    )
    Customer  findCustomerById(Long id);

    @Override
    @QueryHints(
        value = {
            @QueryHint(
                name = org.hibernate.annotations.QueryHints.FLUSH_MODE,
                value = "ALWAYS"
            )
        }
    )
    Optional<Customer> findById(Long id);

    Customer  findByIdNamedQuery(Long id);

    @Query(
        value = "select alias_id from customer where id=?",
        nativeQuery = true
    )
    String getAliasId(Long id);
}
