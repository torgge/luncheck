package com.datapar.domain.evento.Controller;

import com.datapar.domain.cardapio.model.Cardapio;
import com.datapar.domain.cardapio.model.Prato;
import com.datapar.domain.cardapio.model.TipoDePrato;
import com.datapar.domain.evento.model.Evento;
import com.datapar.domain.evento.repository.EventoRepository;
import com.datapar.domain.evento.service.EventoService;
import com.datapar.domain.usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by George Bonespirito on 28/06/2017.
 */
@RestController
public class EventoRestController {

    @Autowired
    private EventoRepository repository;

    @Autowired
    private EventoService service;

    private Evento evento;

    private List<Evento> eventos;

    private List<Usuario> usuarios;

    private List<Prato> pratos;

    public EventoRestController() {

    }

    @RequestMapping("/eventos")
    public Iterable<Evento> getAll() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario().setUserId("Juca"));

        pratos = new ArrayList<>();
        pratos.add(new Prato().setDescricao("Arroz com Linguiça").setTipoDePrato(TipoDePrato.PRATO_QUENTE));
        pratos.add(new Prato().setDescricao("Guizo de Mandioca").setTipoDePrato(TipoDePrato.PRATO_QUENTE));
        pratos.add(new Prato().setDescricao("Ensaladas").setTipoDePrato(TipoDePrato.SALADA));

        evento = new Evento()
                .setData(new Date())
                .setId(1L)
                .setUsuarios(usuarios)
                .setCardapio(new Cardapio().setPratos(pratos).setDescricao("Cardapio de Quinta-Feira"));
        eventos = new ArrayList<>();
        eventos.add(evento);

        return eventos;
    }


}
