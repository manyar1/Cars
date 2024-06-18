package ru.daniel.MoscowDrive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.daniel.MoscowDrive.models.ComfortPlus;
import ru.daniel.MoscowDrive.repositories.ComfortPlusRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ComfortPlusService {
    private final ComfortPlusRepository comfortPlusRepository;

    @Autowired
    public ComfortPlusService(ComfortPlusRepository comfortPlusRepository) {
        this.comfortPlusRepository = comfortPlusRepository;
    }

    public List<ComfortPlus> findAll() {
        if (true)
            return comfortPlusRepository.findAll(Sort.by("brand"));
        else
            return comfortPlusRepository.findAll();
    }


    public ComfortPlus findOne(int id) {
        Optional<ComfortPlus> foundComfortPlus= comfortPlusRepository.findById(id);
        return foundComfortPlus.orElse(null);
    }


    @Transactional
    public void save(ComfortPlus comfortPlus) {
        comfortPlusRepository.save(comfortPlus);
    }

    @Transactional
    public void update(int id, ComfortPlus updatedComfortPlus) {
        ComfortPlus comfortPlusToBeUpdated = comfortPlusRepository.findById(id).get();

        updatedComfortPlus.setId(id);
        comfortPlusRepository.save(updatedComfortPlus);
    }

    @Transactional
    public void delete(int id) {
        comfortPlusRepository.deleteById(id);
    }
}
