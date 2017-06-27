package datapar.com.py.checkfood.model;

import java.util.Calendar;

import datapar.com.py.checkfood.model.vo.TipoEvento;

public class Evento {

    private TipoEvento tipoEvento;

    private String nomeEvento;

    private Empresa empresa;

    private Calendar dataEvento;

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

}
