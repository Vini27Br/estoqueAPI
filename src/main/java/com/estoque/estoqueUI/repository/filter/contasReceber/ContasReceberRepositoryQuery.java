package com.estoque.estoqueUI.repository.filter.contasReceber;

import com.estoque.estoqueUI.repository.filter.ContasReceberFilter;
import com.estoque.estoqueUI.repository.projections.ContasReceberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContasReceberRepositoryQuery {

    public Page<ContasReceberDto> filtrar(ContasReceberFilter contasReceberFilter, Pageable pageable);

}
