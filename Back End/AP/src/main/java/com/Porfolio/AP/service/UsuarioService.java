
package com.Porfolio.AP.service;

import com.Porfolio.AP.model.Usuar;
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
    
    
    public Usuar addUser(Usuar usuario){
        return usuarioRepo.save(usuario);
    }
    
    public List<Usuar> buscarUser(Usuar usuario){
        return usuarioRepo.findAll();
    }
    
    public Usuar editarUser(Usuar usuar){
        return usuarioRepo.save(usuar);
    }
    
    public void borrarUser(Long id){
        usuarioRepo.deleteById(id);
    }

    public Usuar buscarUsuarioPorId(Long id){
        return usuarioRepo.findById(id).orElse(null);
    }
    
}
