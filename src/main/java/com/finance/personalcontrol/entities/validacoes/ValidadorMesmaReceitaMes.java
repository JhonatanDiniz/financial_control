package com.finance.personalcontrol.entities.validacoes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finance.personalcontrol.entities.dto.ReceitaCadastroDTO;
import com.finance.personalcontrol.repositories.ReceitaRepository;
import com.finance.personalcontrol.services.exceptions.ValidacaoException;

@Component
public class ValidadorMesmaReceitaMes implements ValidadorReceitas {
	
	@Autowired
	ReceitaRepository receitaRepository;
	
	public void validar(ReceitaCadastroDTO obj) {
		var dataAtual = LocalDate.now();
		var periodoIni = dataAtual.withDayOfMonth(1);
		var periodoFin = dataAtual.withDayOfMonth(dataAtual.lengthOfMonth());
		
		var receitaCadastrada = receitaRepository.buscaDescricaoMes(obj.descricao(), periodoIni, periodoFin);
		
		if(receitaCadastrada != null && receitaCadastrada.getDescricao().equalsIgnoreCase(obj.descricao())) {
			System.out.println("Receita: " + receitaCadastrada.toString());
			throw new ValidacaoException("Receita já cadastrada!");
		}	
	}

}
