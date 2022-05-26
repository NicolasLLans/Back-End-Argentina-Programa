
package com.Porfolio.AP.repository;

import com.Porfolio.AP.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepo extends JpaRepository <Usuario, Long> {
    
}
