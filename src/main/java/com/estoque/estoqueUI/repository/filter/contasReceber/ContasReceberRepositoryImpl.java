package com.estoque.estoqueUI.repository.filter.contasReceber;

import com.estoque.estoqueUI.model.ContasReceber;
import com.estoque.estoqueUI.repository.filter.ContasReceberFilter;
import com.estoque.estoqueUI.repository.projections.ContasReceberDto;
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

public class ContasReceberRepositoryImpl implements ContasReceberRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

   @Override
    public Page<ContasReceberDto> filtrar(ContasReceberFilter contasReceberFilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<ContasReceberDto> criteria = builder.createQuery(ContasReceberDto.class);

        Root<ContasReceber> root = criteria.from(ContasReceber.class);


        criteria.select(builder.construct(ContasReceberDto.class,
                root.get("idcr"),
                root.get("data"),
                root.get("valorconta"),
                root.get("cliente").get("nomecliente"))

   );


        Predicate[] predicates = criarRestrições(contasReceberFilter, builder, root);

        criteria.where(predicates);

        criteria.orderBy(builder.asc(root.get("cliente").get("nomecliente")));


        TypedQuery<ContasReceberDto> query = manager.createQuery(criteria);

        adcionarRestricoesPaginacao(query, pageable);


        return new PageImpl<>(query.getResultList(),pageable, total(contasReceberFilter));
    }

    private void adcionarRestricoesPaginacao(TypedQuery<?> query, Pageable pageable) {

        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistrosPorPagina);

    }

    private Long total(ContasReceberFilter contasReceberFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

        Root<ContasReceber> root = criteria.from(ContasReceber.class);


        Predicate[] predicates = criarRestrições(contasReceberFilter, builder, root);

        criteria.where(predicates);

        criteria.orderBy(builder.asc(root.get("data")));

        criteria.select(builder.count(root));

        return  manager.createQuery(criteria).getSingleResult();

    }

    private Predicate[] criarRestrições(ContasReceberFilter contasReceberFilter, CriteriaBuilder builder, Root<ContasReceber> root) {

        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(contasReceberFilter.getNomecliente())){
            predicates.add(builder.like(builder.lower(root.get("cliente").get("nomecliente")),
                    "%" + contasReceberFilter.getNomecliente().toLowerCase() + "%"));
        }



          if (contasReceberFilter.getData() != null ){
                  predicates.add(builder.greaterThanOrEqualTo(root.get("data"),
                          contasReceberFilter.getData()));
              }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

}
