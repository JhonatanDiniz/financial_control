package com.finance.personalcontrol.entities.validacoes;

import org.springframework.stereotype.Component;

import com.finance.personalcontrol.entities.dto.ReceitaCadastroDTO;
import com.finance.personalcontrol.services.exceptions.ValidacaoException;

@Component
public class ValidadorReceitaNull implements ValidadorReceitas {
	
	public void validar(ReceitaCadastroDTO obj) {
		if(obj.descricao() == null) {
			throw new ValidacaoException("Descrição não pode ser nula!");
		}		
	}

}
