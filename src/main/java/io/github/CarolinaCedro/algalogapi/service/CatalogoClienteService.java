package io.github.CarolinaCedro.algalogapi.service;

import io.github.CarolinaCedro.algalogapi.domain.entities.Cliente;
import io.github.CarolinaCedro.algalogapi.domain.repository.ClienteRepository;
import io.github.CarolinaCedro.algalogapi.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogoClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente save(Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExiste -> !clienteExiste.equals(cliente));

        if (emailEmUso){
            throw new DomainException("Já existe um cliente cadastrado com este e-mail");
        }

        return clienteRepository.save(cliente);
    }

    @Transactional
    public void delete(Long id){
        clienteRepository.deleteById(id);
    }
}
