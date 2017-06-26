package com.datapar.domain.usuario.service;

import com.datapar.domain.usuario.model.Usuario;
import com.datapar.domain.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by George Bonespirito on 24/06/2017.
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public UsuarioService() {
    }

    public void salvar(Usuario usuario) {
        repository.save(usuario);
    }

    public void remover(Usuario usuario) {
        repository.delete(usuario);
    }

    public Iterable<Usuario> buscaTodosUsuarios() {
        return repository.findAll();
    }

    public Usuario logar(String userId, String password) {
        return repository.findFirstByUserIdAndPassword(userId, password);
    }
}
