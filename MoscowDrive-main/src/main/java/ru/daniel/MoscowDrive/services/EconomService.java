package ru.daniel.MoscowDrive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.daniel.MoscowDrive.models.Econom;
import ru.daniel.MoscowDrive.repositories.EconomRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EconomService {

    private final EconomRepository economRepository;

    @Autowired
    public EconomService(EconomRepository economRepository) {
        this.economRepository = economRepository;
    }

    public List<Econom> findAll() {
        if (true)
            return economRepository.findAll(Sort.by("brand"));
        else
            return economRepository.findAll();
    }


    public Econom findOne(int id) {
        Optional<Econom> foundEconom = economRepository.findById(id);
        return foundEconom.orElse(null);
    }


    @Transactional
    public void save(Econom econom) {
        economRepository.save(econom);
    }

    @Transactional
    public void update(int id, Econom updatedEconom) {
        Econom economToBeUpdated = economRepository.findById(id).get();

        updatedEconom.setId(id);
        economRepository.save(updatedEconom);
    }

    @Transactional
    public void delete(int id) {
        economRepository.deleteById(id);
    }
}
