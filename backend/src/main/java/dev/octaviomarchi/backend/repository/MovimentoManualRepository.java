package dev.octaviomarchi.backend.repository;

import dev.octaviomarchi.backend.model.MovimentoManual;
import dev.octaviomarchi.backend.model.MovimentoManualId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface MovimentoManualRepository extends JpaRepository<MovimentoManual, MovimentoManualId> {

    @Query("select count(m.datMovimento) from MovimentoManual m where m.datAno = :ano and m.datMes = :mes and m.datMovimento < CURRENT_TIMESTAMP")
    int getNumeroLancamentos(Long mes, Long ano);

}
