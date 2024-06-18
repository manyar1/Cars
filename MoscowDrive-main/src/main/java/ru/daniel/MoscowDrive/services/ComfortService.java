package ru.daniel.MoscowDrive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.daniel.MoscowDrive.models.Comfort;
import ru.daniel.MoscowDrive.repositories.ComfortRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ComfortService {
    private final ComfortRepository comfortRepository;

    @Autowired
    public ComfortService(ComfortRepository comfortRepository) {
        this.comfortRepository = comfortRepository;
    }

    public List<Comfort> findAll() {
        if (true)
            return comfortRepository.findAll(Sort.by("brand"));
        else
            return comfortRepository.findAll();
    }


    public Comfort findOne(int id) {
        Optional<Comfort> foundComfort= comfortRepository.findById(id);
        return foundComfort.orElse(null);
    }


    @Transactional
    public void save(Comfort comfort) {
        comfortRepository.save(comfort);
    }

    @Transactional
    public void update(int id, Comfort updatedComfort) {
        Comfort comfortToBeUpdated = comfortRepository.findById(id).get();

        updatedComfort.setId(id);
        comfortRepository.save(updatedComfort);
    }

    @Transactional
    public void delete(int id) {
        comfortRepository.deleteById(id);
    }
}
