package com.finance.personalcontrol.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.finance.personalcontrol.entities.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{

	@Query("""
			SELECT r
			FROM Receita r
			WHERE r.descricao = :descricao
			AND r.data >= :periodoIni 
			AND r.data <= :periodoFin
			""")
	Receita buscaReceitasMes(String descricao, LocalDate periodoIni, LocalDate periodoFin);




}
