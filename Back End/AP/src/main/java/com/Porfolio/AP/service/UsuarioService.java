
package com.Porfolio.AP.service;

import com.Porfolio.AP.model.Usuario;
import com.Porfolio.AP.repository.UsuarioRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepo usuarioRepo;
    
    @Autowired
    public UsuarioService(UsuarioRepo usuarioRepo){
        this.usuarioRepo = usuarioRepo;
    }
    
    
    public Usuario addUser(Usuario usuario){
        return usuarioRepo.save(usuario);
    }
    
    public List<Usuario> buscarUser(Usuario usuario){
        return usuarioRepo.findAll();
    }
    
    public Usuario editarUser(Usuario usuario){
        return usuarioRepo.save(usuario);
    }
    
    public void borrarUser(Long id){
        usuarioRepo.deleteById(id);
    }

    public Usuario buscarUsuarioPorId(Long id){
        return usuarioRepo.findById(id).orElse(null);
    }
    
}
