package ru.daniel.MoscowDrive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.daniel.MoscowDrive.models.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Integer> {
}
