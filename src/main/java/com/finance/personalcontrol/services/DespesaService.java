package com.finance.personalcontrol.services;

import com.finance.personalcontrol.entities.Despesa;
import com.finance.personalcontrol.entities.dto.DespesaCadastroDTO;
import com.finance.personalcontrol.entities.dto.DespesaDetalheDTO;
import com.finance.personalcontrol.entities.validacoes.ValidadorDespesas;
import com.finance.personalcontrol.repositories.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private List<ValidadorDespesas> validadorDespesas;

    public DespesaDetalheDTO create(DespesaCadastroDTO obj){

        validadorDespesas.forEach(v -> v.validar(obj));

        var despesa = new Despesa(obj);
        despesaRepository.save(despesa);
        return new DespesaDetalheDTO(despesa);
    }
}
