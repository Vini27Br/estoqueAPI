package com.estoque.estoqueUI.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "contasreceber")
public class ContasReceber {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private int idcr;

    private Date data;

    private BigDecimal valorconta;

    @ManyToOne
    @JoinColumn(name="idcl")
    private Cliente cliente;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContasReceber that = (ContasReceber) o;
        return idcr == that.idcr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcr);
    }
}
