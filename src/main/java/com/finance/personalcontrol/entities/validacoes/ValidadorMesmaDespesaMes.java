package com.finance.personalcontrol.entities.validacoes;

import com.finance.personalcontrol.entities.dto.DespesaCadastroDTO;
import com.finance.personalcontrol.repositories.DespesaRepository;
import com.finance.personalcontrol.services.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ValidadorMesmaDespesaMes implements ValidadorDespesas {

    @Autowired
    private DespesaRepository despesaRepository;

    public void validar(DespesaCadastroDTO obj){
        var dataAtual = LocalDate.now();
        var periodoIni = dataAtual.withDayOfMonth(1);
        var periodoFin = dataAtual.withDayOfMonth(dataAtual.lengthOfMonth());

        var despesaCadastrada = despesaRepository.buscaDespesasMes(obj.descricao(), periodoIni, periodoFin);

        if(despesaCadastrada != null && despesaCadastrada.getDescricao().equalsIgnoreCase(obj.descricao())){
            throw new ValidacaoException("Despesa já cadastrada.");
        }
    }
}
