package com.estoque.estoqueUI.resource;

import com.estoque.estoqueUI.model.ContasReceber;
import com.estoque.estoqueUI.repository.ContasReceberRepository;
import com.estoque.estoqueUI.repository.filter.ContasReceberFilter;
import com.estoque.estoqueUI.repository.projections.ContasReceberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contasreceber")

public class ContasReceberResource {

    @Autowired
    private ContasReceberRepository contasReceberRepository;

    @GetMapping("/todos")
    public List<ContasReceber> ListarTodosContaReceber(){

        return contasReceberRepository.findAll();
    }

    @GetMapping()
    public Page<ContasReceberDto> pesquisar(ContasReceberFilter contasReceberFilter, Pageable pageable){

        return contasReceberRepository.filtrar(contasReceberFilter, pageable);
    }

}
