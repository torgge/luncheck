package com.datapar.domain.cardapio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by George Bonespirito on 24/06/2017.
 */

@Entity
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String descricao;
    @Enumerated(EnumType.STRING)
    TipoDePrato tipoDePrato;
    @JsonIgnore
    @ManyToMany(mappedBy="pratos", cascade = CascadeType.ALL)
    private List<Cardapio> cardapios;

    public Prato() {
    }

    public List<Cardapio> getCardapios() {
        return cardapios;
    }

    public Prato setId(Long id) {
        this.id = id;
        return this;
    }

    public Prato setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Prato setTipoDePrato(TipoDePrato tipoDePrato) {
        this.tipoDePrato = tipoDePrato;
        return this;
    }

    public Prato setCardapios(List<Cardapio> cardapios) {
        this.cardapios = cardapios;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoDePrato getTipoDePrato() {
        return tipoDePrato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prato)) return false;

        Prato prato = (Prato) o;

        if (getId() != null ? !getId().equals(prato.getId()) : prato.getId() != null) return false;
        if (getDescricao() != null ? !getDescricao().equals(prato.getDescricao()) : prato.getDescricao() != null)
            return false;
        return getTipoDePrato() == prato.getTipoDePrato();
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDescricao() != null ? getDescricao().hashCode() : 0);
        result = 31 * result + (getTipoDePrato() != null ? getTipoDePrato().hashCode() : 0);
        return result;
    }
}
