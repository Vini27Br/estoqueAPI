package com.estoque.estoqueUI.repository.filter.cliente;

import com.estoque.estoqueUI.model.Cliente;
import com.estoque.estoqueUI.repository.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {

    public Page<Cliente> Filtrar(
            ClienteFilter clienteFilter, Pageable pageable
    );

}
