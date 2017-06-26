package com.datapar.domain.cardapio.model;

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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CARDAPIO_PRATO",
               joinColumns = {@JoinColumn(name = "CARDAPIO_ID")},
               inverseJoinColumns = {@JoinColumn(name = "PRATO_ID")})
    List<Cardapio> cardapios;
    @Enumerated(EnumType.STRING)
    TipoDePrato tipoDePrato;

    public Prato() {
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

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoDePrato getTipoDePrato() {
        return tipoDePrato;
    }

    public Prato setCardapios(List<Cardapio> cardapios) {
        this.cardapios = cardapios;
        return this;
    }

    public List<Cardapio> getCardapios() {
        return cardapios;
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
