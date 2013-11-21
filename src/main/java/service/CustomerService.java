package service;

import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CustomerRepository;

/**
 * @author Alexey
 */
@Service
@Transactional(readOnly = true)
public class CustomerService implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUserName(username);
        if (customer == null) {
            throw new UsernameNotFoundException("Customer with username '" + username + "' was not found!");
        }
        return customer;
    }

    public Customer getById (Long id) {
        return customerRepository.findOne(id);
    }

    public Customer save (Customer customer) {
        return customerRepository.save(customer);
    }

}
