package ru.daniel.MoscowDrive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.daniel.MoscowDrive.models.Comfort;

@Repository
public interface ComfortRepository extends JpaRepository<Comfort, Integer> {
}
