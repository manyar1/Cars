package ru.daniel.MoscowDrive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.daniel.MoscowDrive.models.Econom;

@Repository
public interface EconomRepository extends JpaRepository<Econom, Integer> {
}
