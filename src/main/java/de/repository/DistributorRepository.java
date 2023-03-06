package de.repository;

import de.model.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DistributorRepository extends JpaRepository<Distributor, Long> {
  @Query("SELECT d FROM Distributor d WHERE d.name = ?1")
  Optional<Distributor> findByName(String name);
}
