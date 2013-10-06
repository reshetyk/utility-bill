package service;

import domain.Apartment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ApartmentRepository;

import javax.annotation.Resource;

/**
 * @author Alexey
 */
@Service
public class ApartmentService {

    @Resource
    ApartmentRepository apartmentRepository;

    @Transactional(readOnly = true)
    public Iterable<Apartment> findAll() {
        return apartmentRepository.findAll();
    }

    public void save (Apartment apartment) {
        apartmentRepository.save(apartment);
    }
}
