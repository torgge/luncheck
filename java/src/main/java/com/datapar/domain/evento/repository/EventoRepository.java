package com.datapar.domain.evento.repository;

import com.datapar.domain.evento.model.Evento;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by George Bonespirito on 28/06/2017.
 */
public interface EventoRepository extends CrudRepository<Evento, Long> {
}
