package com.datapar.domain.cardapio.service;

import com.datapar.domain.cardapio.model.Cardapio;
import com.datapar.domain.cardapio.model.Prato;
import com.datapar.domain.cardapio.repository.CardapioRepository;
import com.datapar.domain.cardapio.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by George Bonespirito on 25/06/2017.
 */
@Service
public class CardapioService {

    @Autowired
    CardapioRepository cardapioRepository;

    @Autowired
    PratoRepository pratoRepository;

    public CardapioService() {
    }

    public void salvar(Cardapio cardapio) {
        cardapioRepository.save(cardapio);
    }

    public void salvar(Prato prato) {
        pratoRepository.save(prato);
    }
}
