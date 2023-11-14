package com.finance.personalcontrol.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.finance.personalcontrol.entities.dto.ReceitaDetalheDTO;
import com.finance.personalcontrol.entities.dto.ReceitaCadastroDTO;
import com.finance.personalcontrol.services.ReceitaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitaController {
	
	@Autowired
	private ReceitaService receitaService;
	
	@PostMapping
	public ResponseEntity<ReceitaDetalheDTO> create(@RequestBody @Valid ReceitaCadastroDTO obj){
		var receita = receitaService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(receita.id()).toUri();
		return ResponseEntity.created(uri).body(receita);
	}

}
