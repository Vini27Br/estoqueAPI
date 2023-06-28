package com.estoque.estoqueUI.repository;

import com.estoque.estoqueUI.model.ContasReceber;
import com.estoque.estoqueUI.repository.filter.ContasReceberFilter;
import com.estoque.estoqueUI.repository.projections.ContasReceberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasReceberRepository extends JpaRepository<ContasReceber, Integer> {
    Page<ContasReceberDto> filtrar(ContasReceberFilter contasReceberFilter, Pageable pageable);
}
