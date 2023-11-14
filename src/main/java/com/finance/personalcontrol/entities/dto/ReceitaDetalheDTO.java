package com.finance.personalcontrol.entities.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.finance.personalcontrol.entities.Receita;

public record ReceitaDetalheDTO(Long id, String descricao, BigDecimal valor, @JsonFormat(pattern = "dd/MM/yyyy") LocalDate data ) {

	public ReceitaDetalheDTO(Receita income) {
		this(income.getId(), income.getDescricao(), income.getValor(), income.getData());
	}

}
