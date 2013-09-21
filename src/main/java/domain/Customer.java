package domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @JoinTable(
            name = "CustomerByApartment",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "apartment_id")
    )
    private Set<Apartment> apartments;

    private String firstName;
    private String lastName;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(Set<Apartment> apartments) {
        this.apartments = apartments;
    }
}
