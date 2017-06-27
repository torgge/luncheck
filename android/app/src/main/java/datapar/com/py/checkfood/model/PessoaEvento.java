package datapar.com.py.checkfood.model;

import java.util.Calendar;

public class PessoaEvento {

    private Pessoa pessoa;

    private Evento evento;

    private Calendar horaCheckin;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Calendar getHoraCheckin() {
        return horaCheckin;
    }

    public void setHoraCheckin(Calendar horaCheckin) {
        this.horaCheckin = horaCheckin;
    }
}
