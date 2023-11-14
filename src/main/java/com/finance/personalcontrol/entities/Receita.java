package com.finance.personalcontrol.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.finance.personalcontrol.entities.dto.ReceitaCadastroDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "receitas")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Receita {
	
	public Receita(ReceitaCadastroDTO obj) {
		this.descricao = obj.descricao();
		this.valor = obj.valor();
		this.data = LocalDate.now();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	private BigDecimal valor;
	
	@NotNull
	private LocalDate data = LocalDate.now();

}
