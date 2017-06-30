package com.datapar.domain.evento.controller;

import com.datapar.domain.cardapio.model.Cardapio;
import com.datapar.domain.cardapio.model.Prato;
import com.datapar.domain.cardapio.model.TipoDePrato;
import com.datapar.domain.evento.model.Evento;
import com.datapar.domain.evento.repository.EventoRepository;
import com.datapar.domain.evento.service.EventoService;
import com.datapar.domain.usuario.model.Usuario;
import com.datapar.domain.usuario.repository.UsuarioRepository;
import com.datapar.domain.usuario.service.UsuarioService;
import com.datapar.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by George Bonespirito on 28/06/2017.
 */
@RestController
@RequestMapping("/api")
public class EventoRestController {

    public static final Logger logger = LoggerFactory.getLogger(EventoRestController.class);

    private Evento evento;
    private List<Evento> eventos;
    private List<Usuario> usuarios;
    private List<Prato> pratos;
    private Cardapio cardapio;

    @Autowired
    private EventoRepository repository;

    @Autowired
    private EventoService service;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private void init() {
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
    }

    public EventoRestController() {

    }

    @RequestMapping("/eventos")
    public Iterable<Evento> getAll() {
        init();
        return repository.findAll();
    }

    @RequestMapping(value = "/evento/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getEvento(@PathVariable("id") long id) {
        logger.info("Evento com Id: {}", id);

        Evento novoEvento = repository.findOne(id);

        if (novoEvento == null) {
            logger.error("O Evento com id {} não foi encontrado.", id);
            return new ResponseEntity(new CustomErrorType("O Evento com id " + id
                    + " não foi encontrado."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Evento>(novoEvento, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") long id) {
        logger.info("Usuario com Id: {}", id);

        Usuario novoUsuario = usuarioRepository.findOne(id);

        if (novoUsuario == null) {
            logger.error("O Usuario com id {} não foi encontrado.", id);
            return new ResponseEntity(new CustomErrorType("O Usuario com id " + id
                    + " não foi encontrado."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Usuario>(novoUsuario, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuario/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody Usuario usuario, UriComponentsBuilder ucBuilder) {
        logger.info("Creating usuario : {}", usuario);

        if (usuarioService.isUsuarioExists(usuario)) {
            logger.error("Não foi possível criar usuario. O usuário {} já existe", usuario.getUserId());
            return new ResponseEntity(new CustomErrorType("Não foi possível criar usuario. O usuário " +
                    usuario.getUserId() + " já existe."),HttpStatus.CONFLICT);
        }
        usuarioService.salvar(usuario);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/usuario/{id}").buildAndExpand(usuario.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting User with id {}", id);

        Usuario user = usuarioRepository.findOne(id);

        if (user == null) {
            logger.error("Não foi possível remover o usuário. Usuário com id {} não encontrado.", id);
            return new ResponseEntity(new CustomErrorType("Não foi possível remover o usuário. Usuário com id " + id + " não encontrado."),
                    HttpStatus.NOT_FOUND);
        }
        usuarioService.remover(user);

        return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
    }




}
