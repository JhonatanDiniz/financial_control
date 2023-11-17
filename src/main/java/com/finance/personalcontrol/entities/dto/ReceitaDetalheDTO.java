package com.finance.personalcontrol.entities.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.finance.personalcontrol.entities.Receita;

public record ReceitaDetalheDTO(Long id, String descricao, BigDecimal valor, @JsonFormat(pattern = "dd/MM/yyyy") LocalDate data ) {

	public ReceitaDetalheDTO(Receita income) {
		this(income.getId(), income.getDescricao(), income.getValor(), income.getData());
	}

    public ReceitaDetalheDTO(Optional<Receita> receita) {
		this(receita.get().getId(), receita.get().getDescricao(), receita.get().getValor(), receita.get().getData());
    }
}
