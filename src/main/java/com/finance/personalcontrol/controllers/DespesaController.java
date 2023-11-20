package com.finance.personalcontrol.controllers;

import com.finance.personalcontrol.entities.dto.DespesaCadastroDTO;
import com.finance.personalcontrol.entities.dto.DespesaDetalheDTO;
import com.finance.personalcontrol.entities.dto.ReceitaCadastroDTO;
import com.finance.personalcontrol.services.DespesaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping
    public ResponseEntity<DespesaDetalheDTO> create(@RequestBody @Valid DespesaCadastroDTO obj){
        var despesa = despesaService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(despesa.id()).toUri();
        return ResponseEntity.created(uri).body(despesa);
    }

    @GetMapping
    public ResponseEntity<List<DespesaDetalheDTO>> findAll(){
        var despesas = despesaService.findAll();
        return ResponseEntity.ok().body(despesas);
    }
}
