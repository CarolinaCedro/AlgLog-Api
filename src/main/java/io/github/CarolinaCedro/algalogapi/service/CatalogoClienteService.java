package io.github.CarolinaCedro.algalogapi.service;

import io.github.CarolinaCedro.algalogapi.domain.entities.Cliente;
import io.github.CarolinaCedro.algalogapi.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogoClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void delete(Long id){
        clienteRepository.deleteById(id);
    }
}
