package io.github.CarolinaCedro.algalogapi.domain.repository;

import io.github.CarolinaCedro.algalogapi.domain.entities.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega,Long> {
}
