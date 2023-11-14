package com.finance.personalcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance.personalcontrol.entities.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{

}
