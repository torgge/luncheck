package com.datapar.domain.usuario.repository;

import com.datapar.domain.usuario.model.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by George Bonespirito on 24/06/2017.
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findFirstByUserIdAndPassword(String userId, String password);
}
