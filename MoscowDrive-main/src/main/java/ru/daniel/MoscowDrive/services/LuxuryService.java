package ru.daniel.MoscowDrive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.daniel.MoscowDrive.models.Luxury;
import ru.daniel.MoscowDrive.repositories.LuxuryRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class LuxuryService {
    private final LuxuryRepository luxuryRepository;

    @Autowired
    public LuxuryService(LuxuryRepository luxuryRepository) {
        this.luxuryRepository = luxuryRepository;
    }

    public List<Luxury> findAll() {
        if (true)
            return luxuryRepository.findAll(Sort.by("brand"));
        else
            return luxuryRepository.findAll();
    }


    public Luxury findOne(int id) {
        Optional<Luxury> foundLuxury = luxuryRepository.findById(id);
        return foundLuxury.orElse(null);
    }


    @Transactional
    public void save(Luxury luxury) {
        luxuryRepository.save(luxury);
    }

    @Transactional
    public void update(int id, Luxury updatedLuxury) {
        Luxury luxuryToBeUpdated = luxuryRepository.findById(id).get();

        updatedLuxury.setId(id);
        luxuryRepository.save(updatedLuxury);
    }

    @Transactional
    public void delete(int id) {
        luxuryRepository.deleteById(id);
    }
}
