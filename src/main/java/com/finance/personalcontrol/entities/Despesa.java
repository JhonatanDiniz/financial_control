package com.finance.personalcontrol.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.finance.personalcontrol.entities.dto.DespesaCadastroDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="despesas")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Despesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private BigDecimal valor;
	private LocalDate data;

	public Despesa(DespesaCadastroDTO obj) {
		this.descricao = obj.descricao();
		this.valor = obj.valor();
		this.data = obj.data();
	}
}
