package com.estoque.estoqueUI.repository.filter.cliente;

import com.estoque.estoqueUI.model.Cliente;
import com.estoque.estoqueUI.repository.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepositoryQuery{


    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Cliente> Filtrar(ClienteFilter clienteFilter, Pageable pageable) {


        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);

        Root<Cliente> root = criteria.from(Cliente.class);


        Predicate[] predicates = criarRestricoes(clienteFilter, builder, root);

        criteria.where(predicates);

        criteria.orderBy(builder.asc(root.get("nomecliente")));


        TypedQuery<Cliente> query = manager.createQuery(criteria);

        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(clienteFilter));
    }

    private Long total(ClienteFilter cursoFilter) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

        Root<Cliente> root = criteria.from(Cliente.class);


        Predicate[] predicates = criarRestricoes(cursoFilter, builder, root);

        criteria.where(predicates);

        criteria.orderBy(builder.asc(root.get("nomecliente")));


        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();

    }

    private void adicionarRestricoesDePaginacao(TypedQuery<Cliente> query, Pageable pagable) {

        int paginaAtual = pagable.getPageNumber();
        int totalRegistrosPorPagina = pagable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistrosPorPagina);

    }

    private Predicate[] criarRestricoes(ClienteFilter cursoFilter, CriteriaBuilder builder, Root<Cliente> root) {

        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(cursoFilter.getNomecliente())){
            predicates.add(builder.like(builder.lower(root.get("nomecliente")),
                    "%" + cursoFilter.getNomecliente().toLowerCase() + "%"));
        }
        return predicates.toArray(new Predicate[predicates.size()]);
    }

}
