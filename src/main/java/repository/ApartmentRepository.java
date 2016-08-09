package repository;

import domain.Apartment;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ApartmentRepository extends CrudRepository<Apartment, Long>, QueryDslPredicateExecutor<Apartment> {

//	List<Apartment> findByCustomer(Customer customer);
}
