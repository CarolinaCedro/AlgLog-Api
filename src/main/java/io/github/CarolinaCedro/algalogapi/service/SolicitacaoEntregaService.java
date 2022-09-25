package io.github.CarolinaCedro.algalogapi.service;

import io.github.CarolinaCedro.algalogapi.domain.entities.Entrega;
import io.github.CarolinaCedro.algalogapi.domain.entities.StatusEntrega;
import io.github.CarolinaCedro.algalogapi.domain.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class SolicitacaoEntregaService {
    @Autowired
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        return entregaRepository.save(entrega);
    }
}
