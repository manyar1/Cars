package ru.daniel.MoscowDrive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.daniel.MoscowDrive.models.ComfortPlus;

@Repository
public interface ComfortPlusRepository extends JpaRepository<ComfortPlus, Integer> {
}
