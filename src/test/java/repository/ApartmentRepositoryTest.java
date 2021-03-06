package repository;

import domain.Apartment;
import domain.QApartment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @author Oliver Gierke
 */
@ContextConfiguration("classpath:spring/application-context.xml")
public class ApartmentRepositoryTest extends BaseTest {

    @Autowired
    ApartmentRepository apartmentRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void saveApartment() {
        Apartment apartment = apartmentRepository.save(new Apartment());
        assertThat(apartment.getId(), is(notNullValue()));
    }

    @Test
    public void findOne () {
        Apartment apartment = apartmentRepository.findOne(2L);
        assertNotNull(apartment);
        assertThat(apartment.getName(), is("home donetsk"));
    }

    @Test
    public void findBySearchCriteria () {
        Iterable<Apartment> donetsk = apartmentRepository.findAll(QApartment.apartment.name.like("%donetsk%"));
        Apartment apartment = donetsk.iterator().next();
        assertNotNull(apartment);
        assertThat(apartment.getName(), is("home donetsk"));
    }

}
