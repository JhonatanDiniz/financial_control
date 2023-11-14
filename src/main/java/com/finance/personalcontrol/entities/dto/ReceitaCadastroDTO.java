package com.finance.personalcontrol.entities.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReceitaCadastroDTO(
		
		@NotBlank
		String descricao,
		@NotNull
		BigDecimal valor,
		@JsonFormat(pattern = "dd/MM/yyyy")
		LocalDate data) {

}
