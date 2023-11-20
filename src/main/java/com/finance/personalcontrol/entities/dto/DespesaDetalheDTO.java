package com.finance.personalcontrol.entities.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.finance.personalcontrol.entities.Despesa;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DespesaDetalheDTO(
        Long id,
        String descricao,
        BigDecimal valor,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate data) {
    public DespesaDetalheDTO(Despesa despesa) {
        this(despesa.getId(), despesa.getDescricao(), despesa.getValor(), despesa.getData());
    }
}
