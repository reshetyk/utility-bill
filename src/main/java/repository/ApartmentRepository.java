package repository;

import java.util.List;

import domain.Apartment;
import domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ApartmentRepository extends CrudRepository<Apartment, Long> {

//	List<Apartment> findByCustomer(Customer customer);
}
