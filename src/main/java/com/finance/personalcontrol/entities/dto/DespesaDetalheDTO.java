package com.finance.personalcontrol.entities.dto;

import com.finance.personalcontrol.entities.Despesa;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DespesaDetalheDTO(Long id, String descricao, BigDecimal valor, LocalDate data) {
    public DespesaDetalheDTO(Despesa despesa) {
        this(despesa.getId(), despesa.getDescricao(), despesa.getValor(), despesa.getData());
    }
}
