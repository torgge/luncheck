package com.datapar.domain.cardapio.service;

import com.datapar.domain.cardapio.model.Cardapio;
import com.datapar.domain.cardapio.model.Prato;
import com.datapar.domain.cardapio.repository.CardapioRepository;
import com.datapar.domain.cardapio.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void removerCardapio(Long id) {
        cardapioRepository.delete(id);
    }

    public void removerPrato(Long id) {
        pratoRepository.delete(id);
    }

    public List<Prato> getPratos (Cardapio cardapio) {
        return pratoRepository.findAllByCardapio(cardapio);
    }

    public Iterable<Cardapio> getCardapios() {
        return cardapioRepository.findAll();
    }

}
