package com.estoque.estoqueUI.repository.filter;

import java.math.BigDecimal;
import java.util.Date;

public class ContasReceberFilter {

    private Date data;

    private String nomecliente;


    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public ContasReceberFilter(Date data, String nomecliente) {
        this.data = data;
        this.nomecliente = nomecliente;
    }
}
