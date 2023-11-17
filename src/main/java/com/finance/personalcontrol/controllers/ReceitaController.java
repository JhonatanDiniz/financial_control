package com.finance.personalcontrol.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

	@PutMapping(value = "/{id}")
	public ResponseEntity<ReceitaDetalheDTO> update(@PathVariable Long id, @RequestBody ReceitaCadastroDTO obj){
		var receita = receitaService.update(id, obj);
		return ResponseEntity.ok().body(receita);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		receitaService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
