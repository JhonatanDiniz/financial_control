package com.finance.personalcontrol.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.personalcontrol.entities.Receita;
import com.finance.personalcontrol.entities.dto.ReceitaCadastroDTO;
import com.finance.personalcontrol.entities.dto.ReceitaDetalheDTO;
import com.finance.personalcontrol.repositories.ReceitaRepository;
import com.finance.personalcontrol.services.exceptions.ValidacaoException;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	public ReceitaDetalheDTO create (ReceitaCadastroDTO obj) {
		if(obj.descricao() == null) {
			throw new ValidacaoException("Descrição não pode ser nula!");
		}
		
		var dataAtual = LocalDate.now();
		var periodoIni = dataAtual.withDayOfMonth(1);
		var periodoFin = dataAtual.withDayOfMonth(dataAtual.lengthOfMonth());
		
		var receitaCadastrada = receitaRepository.buscaDescricaoMes(obj.descricao(), periodoIni, periodoFin);
		
		if(receitaCadastrada != null && receitaCadastrada.getDescricao().equalsIgnoreCase(obj.descricao())) {
			System.out.println("Receita: " + receitaCadastrada.toString());
			throw new ValidacaoException("Receita já cadastrada!");
		}		
		var receita = new Receita(obj);
		receitaRepository.save(receita);
		return new ReceitaDetalheDTO(receita);
	}

}
