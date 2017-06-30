package com.datapar.domain.cardapio.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by George Bonespirito on 24/06/2017.
 */

@Entity
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    String descricao;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "cardapio_prato"
            , joinColumns = @JoinColumn(name = "id_cardapio")
            , inverseJoinColumns = @JoinColumn(name = "id_prato"))
    List<Prato> pratos;

    public Cardapio() {
    }

    public Long getId() {
        return Id;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public Cardapio setId(Long id) {
        Id = id;
        return this;
    }

    public Cardapio setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Cardapio setPratos(List<Prato> pratos) {
        this.pratos = pratos;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cardapio)) return false;

        Cardapio cardapio = (Cardapio) o;

        if (!getId().equals(cardapio.getId())) return false;
        if (getDescricao() != null ? !getDescricao().equals(cardapio.getDescricao()) : cardapio.getDescricao() != null)
            return false;
        return getPratos() != null ? getPratos().equals(cardapio.getPratos()) : cardapio.getPratos() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getDescricao() != null ? getDescricao().hashCode() : 0);
        result = 31 * result + (getPratos() != null ? getPratos().hashCode() : 0);
        return result;
    }
}
