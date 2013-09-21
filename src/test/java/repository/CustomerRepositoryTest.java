package repository;

import domain.Apartment;
import domain.Customer;
import org.hamcrest.collection.IsIterableWithSize;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;
import static org.springframework.data.jpa.domain.Specifications.where;

/**
 * @author Oliver Gierke
 */
@ContextConfiguration("classpath:application-context.xml")
public class CustomerRepositoryTest extends BaseTest {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void findsAllCustomers() throws Exception {

		Iterable<Customer> result = customerRepository.findAll();

		assertThat(result, is(notNullValue()));
		assertTrue(result.iterator().hasNext());
	}

	@Test
	public void findsFirstPageOfMatthews() throws Exception {

		Page<Customer> customers = customerRepository.findByLastName("Matthews", new PageRequest(0, 2));

		assertThat(customers.getContent().size(), is(1));
		assertFalse(customers.hasPreviousPage());
	}

	@Test
	public void findsCustomerById() throws Exception {

		Customer customer = customerRepository.findOne(2L);

		assertThat(customer.getFirstName(), is("Carter"));
		assertThat(customer.getLastName(), is("Beauford"));
	}

	@Test
	public void findCustomersBySpecification() throws Exception {

		Customer dave = customerRepository.findOne(1L);
		List<Customer> result = customerRepository.findAll(where(new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
               return cb.equal(root.get("firstName"),"Dave");
            }
        }));

		assertThat(result.size(), is(1));
		assertThat(result, hasItems(dave));
	}

    @Test
    public void saveCustomer () {
        Customer customer = new Customer("Alex","Reshetiuk");
        customerRepository.save(customer);
        assertNotNull(customer.getId());
        Customer storedCustomer = customerRepository.findOne(customer.getId());
        assertThat(customer, is(storedCustomer));

    }

    @Test
    public void findApartmentsCustomer() {
        Customer customer = customerRepository.findOne(1L);
        Set<Apartment> apartments = customer.getApartments();

        assertThat(apartments, IsIterableWithSize.<Apartment>iterableWithSize(2));
    }
}
