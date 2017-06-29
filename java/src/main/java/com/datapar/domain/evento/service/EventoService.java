package com.datapar.domain.evento.service;

import com.datapar.domain.evento.model.Evento;
import com.datapar.domain.evento.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by George Bonespirito on 28/06/2017.
 */
@Service
public class EventoService {

    @Autowired
    EventoRepository repository;

    public EventoService() {
    }

    public Iterable<Evento> getAll() {
        return repository.findAll();
    }

    public void salvar(Evento evento) {
        repository.save(evento);
    }

    public void remover(Long id) {
        repository.delete(id);
    }
}
