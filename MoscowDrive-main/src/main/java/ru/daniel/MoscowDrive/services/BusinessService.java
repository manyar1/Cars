package ru.daniel.MoscowDrive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.daniel.MoscowDrive.models.Business;
import ru.daniel.MoscowDrive.repositories.BusinessRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BusinessService {
    private final BusinessRepository businessRepository;

    @Autowired
    public BusinessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    public List<Business> findAll() {
        if (true)
            return businessRepository.findAll(Sort.by("brand"));
        else
            return businessRepository.findAll();
    }


    public Business findOne(int id) {
        Optional<Business> foundBusiness = businessRepository.findById(id);
        return foundBusiness.orElse(null);
    }


    @Transactional
    public void save(Business business) {
        businessRepository.save(business);
    }

    @Transactional
    public void update(int id, Business updatedBusiness) {
        Business businessToBeUpdated = businessRepository.findById(id).get();

        updatedBusiness.setId(id);
        businessRepository.save(updatedBusiness);
    }

    @Transactional
    public void delete(int id) {
        businessRepository.deleteById(id);
    }
}
