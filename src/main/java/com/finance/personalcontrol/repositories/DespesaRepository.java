package com.finance.personalcontrol.repositories;

import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import com.finance.personalcontrol.entities.Despesa;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{

    @Query("""
            select d
            from Despesa d
            where d.descricao = :descricao
            and d.data >= :periodoIni
            and d.data <= :periodoFin
            """)
    Despesa buscaDespesasMes(String descricao, LocalDate periodoIni, LocalDate periodoFin);

}
