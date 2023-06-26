package com.estoque.estoqueUI.repository;

import com.estoque.estoqueUI.model.Cliente;
import com.estoque.estoqueUI.repository.filter.ClienteFilter;
import com.estoque.estoqueUI.repository.filter.cliente.ClienteRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>, ClienteRepositoryQuery {

}
