package com.estoque.estoqueUI.model;




import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;


@Entity

@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idcl;

    private String nomecliente ;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore


    public int getIdcl() {
        return idcl;
    }

    public void setIdcl(int idcl) {
        this.idcl = idcl;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return idcl == cliente.idcl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcl);
    }
}
