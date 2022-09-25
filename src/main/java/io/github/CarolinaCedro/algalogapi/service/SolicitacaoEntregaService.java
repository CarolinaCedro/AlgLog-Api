package io.github.CarolinaCedro.algalogapi.service;

import io.github.CarolinaCedro.algalogapi.domain.entities.Cliente;
import io.github.CarolinaCedro.algalogapi.domain.entities.Entrega;
import io.github.CarolinaCedro.algalogapi.domain.entities.StatusEntrega;
import io.github.CarolinaCedro.algalogapi.domain.repository.ClienteRepository;
import io.github.CarolinaCedro.algalogapi.domain.repository.EntregaRepository;
import io.github.CarolinaCedro.algalogapi.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class SolicitacaoEntregaService {
    @Autowired
    private EntregaRepository entregaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CatalogoClienteService catalogoClienteService;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        return entregaRepository.save(entrega);
    }
}
