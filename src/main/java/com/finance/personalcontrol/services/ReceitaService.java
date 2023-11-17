package com.finance.personalcontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.personalcontrol.entities.Receita;
import com.finance.personalcontrol.entities.dto.ReceitaCadastroDTO;
import com.finance.personalcontrol.entities.dto.ReceitaDetalheDTO;
import com.finance.personalcontrol.entities.validacoes.ValidadorReceitas;
import com.finance.personalcontrol.repositories.ReceitaRepository;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Autowired
	private List<ValidadorReceitas> validadorReceitas;
	
	public ReceitaDetalheDTO create (ReceitaCadastroDTO obj) {
		
		validadorReceitas.forEach(v -> v.validar(obj));
		
		var receita = new Receita(obj);
		receitaRepository.save(receita);
		return new ReceitaDetalheDTO(receita);
	}
	
	public List<ReceitaDetalheDTO> findAll () {
		return receitaRepository.findAll().stream().map(ReceitaDetalheDTO::new).toList();
	}
	
	public ReceitaDetalheDTO findById(Long id) {
		var receita = receitaRepository.getReferenceById(id);
		return new ReceitaDetalheDTO(receita);
	}

	public ReceitaDetalheDTO update(Long id, ReceitaCadastroDTO obj){
		var receita = receitaRepository.getReferenceById(id);
		updateData(receita, obj);
		receitaRepository.save(receita);
		return new ReceitaDetalheDTO(receita);
	}

	private void updateData(Receita receita, ReceitaCadastroDTO obj) {
		if(!receita.getDescricao().equalsIgnoreCase(obj.descricao())){
			validadorReceitas.forEach(v -> v.validar(obj));
		}
		receita.setDescricao(obj.descricao());
		receita.setValor(obj.valor());

	}

}
