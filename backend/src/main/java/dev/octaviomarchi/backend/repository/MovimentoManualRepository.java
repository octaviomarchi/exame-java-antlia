package dev.octaviomarchi.backend.repository;

import dev.octaviomarchi.backend.model.MovimentoManual;
import dev.octaviomarchi.backend.model.MovimentoManualId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentoManualRepository extends JpaRepository<MovimentoManual, MovimentoManualId> {

}
