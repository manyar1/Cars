package ru.daniel.MoscowDrive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.daniel.MoscowDrive.models.Luxury;

@Repository
public interface LuxuryRepository extends JpaRepository<Luxury, Integer> {
}
