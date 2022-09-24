package io.github.CarolinaCedro.algalogapi.api.controller;

import io.github.CarolinaCedro.algalogapi.domain.entities.Cliente;
import io.github.CarolinaCedro.algalogapi.domain.repository.ClienteRepository;
import io.github.CarolinaCedro.algalogapi.service.CatalogoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private CatalogoClienteService catalogoClienteService;

    @GetMapping
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody @Valid Cliente cliente) {
        return catalogoClienteService.save(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody @Valid Cliente cliente) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(id);
        return ResponseEntity.ok(catalogoClienteService.save(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        catalogoClienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


