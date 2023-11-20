package com.finance.personalcontrol.entities.validacoes;

import com.finance.personalcontrol.entities.dto.DespesaCadastroDTO;
import com.finance.personalcontrol.services.exceptions.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidadorDespesaNull implements ValidadorDespesas{

    public void validar(DespesaCadastroDTO obj){
        if(obj.descricao() == null){
            throw new ValidacaoException("Descricao da despesa não pode ser nula.");
        }
    }
}
