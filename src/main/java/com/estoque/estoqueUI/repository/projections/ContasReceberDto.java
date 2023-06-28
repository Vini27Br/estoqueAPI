package com.estoque.estoqueUI.repository.projections;

import java.math.BigDecimal;
import java.util.Date;

public class ContasReceberDto {

    private int idcr;

    private Date data;

    private BigDecimal valorconta;

    private String nomecliente;

    public ContasReceberDto(int idcr, Date data, BigDecimal valorconta, String nomecliente){


        this.idcr = idcr;
        this.data = data;
        this.valorconta = valorconta;
        this.nomecliente = nomecliente;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public int getIdcr() {
        return idcr;
    }

    public void setIdcr(int idcr) {
        this.idcr = idcr;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValorconta() {
        return valorconta;
    }

    public void setValorconta(BigDecimal valorconta) {
        this.valorconta = valorconta;
    }
}
