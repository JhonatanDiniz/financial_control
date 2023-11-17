package com.finance.personalcontrol.entities.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DespesaCadastroDTO(String descricao, BigDecimal valor, LocalDate data) {
}
