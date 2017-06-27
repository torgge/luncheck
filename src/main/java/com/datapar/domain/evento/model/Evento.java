package com.datapar.domain.evento.model;

import com.datapar.domain.cardapio.model.Cardapio;
import com.datapar.domain.usuario.model.Usuario;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by George Bonespirito on 26/06/2017.
 */
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Date data;
    @ManyToOne
    @JoinColumn(name = "id_cardapio", referencedColumnName = "id_cardapio")
    Cardapio cardapio;
    @ManyToMany(mappedBy = "eventos")
    List<Usuario> usuarios;

    public Evento() {
    }

    public Long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Evento setId(Long id) {
        this.id = id;
        return this;
    }

    public Evento setData(Date data) {
        this.data = data;
        return this;
    }

    public Evento setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
        return this;
    }

    public Evento setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evento)) return false;

        Evento evento = (Evento) o;

        if (!getId().equals(evento.getId())) return false;
        if (getData() != null ? !getData().equals(evento.getData()) : evento.getData() != null) return false;
        if (getCardapio() != null ? !getCardapio().equals(evento.getCardapio()) : evento.getCardapio() != null)
            return false;
        return getUsuarios() != null ? getUsuarios().equals(evento.getUsuarios()) : evento.getUsuarios() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getData() != null ? getData().hashCode() : 0);
        result = 31 * result + (getCardapio() != null ? getCardapio().hashCode() : 0);
        result = 31 * result + (getUsuarios() != null ? getUsuarios().hashCode() : 0);
        return result;
    }
}
