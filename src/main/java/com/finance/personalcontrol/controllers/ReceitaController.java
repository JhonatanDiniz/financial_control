package com.finance.personalcontrol.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping
	public ResponseEntity<List<ReceitaDetalheDTO>> findAll(){
		var receitas = receitaService.findAll();
		return ResponseEntity.ok().body(receitas);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ReceitaDetalheDTO> findById(@PathVariable Long id){
		var receita = receitaService.findById(id);
		return ResponseEntity.ok().body(receita);
	}

}
