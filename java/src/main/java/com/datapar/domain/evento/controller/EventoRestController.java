package com.datapar.domain.evento.controller;

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

    public EventoRestController() {

    }

    @RequestMapping("/eventos")
    public Iterable<Evento> getAll() {

        Evento evento;
        List<Evento> eventos;
        List<Usuario> usuarios;
        List<Prato> pratos;
        Cardapio cardapio;

        usuarios = new ArrayList<>();
        usuarios.add(new Usuario().setUserId("Juca"));
        usuarios.add(new Usuario().setUserId("Maistarde"));
        usuarios.add(new Usuario().setUserId("Derrepente"));
        usuarios.add(new Usuario().setUserId("Tranquilo"));

        pratos = new ArrayList<>();
        pratos.add(new Prato().setDescricao("Arroz").setTipoDePrato(TipoDePrato.PRATO_QUENTE));
        pratos.add(new Prato().setDescricao("Tarta de Verduras").setTipoDePrato(TipoDePrato.PRATO_QUENTE));
        pratos.add(new Prato().setDescricao("Feijão").setTipoDePrato(TipoDePrato.PRATO_QUENTE));
        pratos.add(new Prato().setDescricao("Fidel Al Ajo").setTipoDePrato(TipoDePrato.PRATO_QUENTE));
        pratos.add(new Prato().setDescricao("Chuleta de Cerdo a la chapa").setTipoDePrato(TipoDePrato.PRATO_QUENTE));
        pratos.add(new Prato().setDescricao("Ensaladas Várias").setTipoDePrato(TipoDePrato.SALADA));
        pratos.add(new Prato().setDescricao("Flan de Chocolate").setTipoDePrato(TipoDePrato.SOBREMESA));
        pratos.add(new Prato().setDescricao("Frutas Tropicales").setTipoDePrato(TipoDePrato.SOBREMESA));

        cardapio = new Cardapio().setDescricao("Cardápio de Quinta-Feira").setPratos(pratos);

        pratos = new ArrayList<>();
        pratos.add(new Prato().setDescricao("Arroz").setTipoDePrato(TipoDePrato.PRATO_QUENTE));
        pratos.add(new Prato().setDescricao("Paloma de Jamon y Queso").setTipoDePrato(TipoDePrato.PRATO_QUENTE));
        pratos.add(new Prato().setDescricao("Feijão").setTipoDePrato(TipoDePrato.PRATO_QUENTE));
        pratos.add(new Prato().setDescricao("Verduras Salteadas").setTipoDePrato(TipoDePrato.PRATO_QUENTE));
        pratos.add(new Prato().setDescricao("Almondegas a salsa roja").setTipoDePrato(TipoDePrato.PRATO_QUENTE));
        pratos.add(new Prato().setDescricao("Ensaladas Várias").setTipoDePrato(TipoDePrato.SALADA));
        pratos.add(new Prato().setDescricao("Ensalada de Frutas").setTipoDePrato(TipoDePrato.SOBREMESA));
        pratos.add(new Prato().setDescricao("Frutas Tropicales").setTipoDePrato(TipoDePrato.SOBREMESA));

        cardapio = new Cardapio().setDescricao("Cardápio de Sexta-Feira").setPratos(pratos);

        eventos = new ArrayList<>();

        evento = new Evento()
                .setData(new Date())
                .setUsuarios(usuarios)
                .setCardapio(cardapio);

        repository.save(evento);

        evento = new Evento()
                .setData(new Date())
                .setUsuarios(usuarios)
                .setCardapio(cardapio);

        repository.save(evento);

        return repository.findAll();
    }


}
