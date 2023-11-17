package com.finance.personalcontrol.services;

import com.finance.personalcontrol.entities.Despesa;
import com.finance.personalcontrol.entities.dto.DespesaCadastroDTO;
import com.finance.personalcontrol.entities.dto.DespesaDetalheDTO;
import com.finance.personalcontrol.repositories.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public DespesaDetalheDTO create(DespesaCadastroDTO obj){
        var despesa = new Despesa(obj);
        despesaRepository.save(despesa);
        return new DespesaDetalheDTO(despesa);
    }
}
