package repository;

import domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>, QueryDslPredicateExecutor<Customer> {

    Customer findByUserName (String login);

    Page<Customer> findByLastName(String lastName, Pageable pageable);
}
