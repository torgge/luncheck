package com.datapar.domain.cardapio.model;

/**
 * Created by George Bonespirito on 24/06/2017.
 */
public enum TipoDePrato {

    PRATO_QUENTE ("PRATO QUENTE"),
    PRATO_FRIO ("PRATO FRIO"),
    SALADA ("SALADA"),
    SOBREMESA ("SOBREMESA");

    private String descricao;

    TipoDePrato(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
