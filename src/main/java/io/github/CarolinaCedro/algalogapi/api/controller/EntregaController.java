package io.github.CarolinaCedro.algalogapi.api.controller;

import io.github.CarolinaCedro.algalogapi.domain.entities.Entrega;
import io.github.CarolinaCedro.algalogapi.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/entregas")
public class EntregaController {

    private SolicitacaoEntregaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@RequestBody Entrega entrega){
        return service.solicitar(entrega);
    }
}
