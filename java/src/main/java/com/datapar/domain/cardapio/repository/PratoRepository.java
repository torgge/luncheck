package com.datapar.domain.cardapio.repository;

import com.datapar.domain.cardapio.model.Cardapio;
import com.datapar.domain.cardapio.model.Prato;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by George Bonespirito on 25/06/2017.
 */
public interface PratoRepository extends CrudRepository<Prato, Long>
{
    List<Prato> findAllByCardapio(Cardapio cardapio);
}
