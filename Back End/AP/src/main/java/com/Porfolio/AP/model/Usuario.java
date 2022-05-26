
package com.Porfolio.AP.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long idUser;
    private String nombreUser;
    private String passUser;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idEdu")
    public List<Educacion> educacionList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idSkill")
    public List<Skills> skillList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idExp")
    public List<Experiencia> experienciaList;
    

    public Usuario() {
    }

    public Usuario(Long idUser, String nombreUser, String passUser) {
        this.idUser = idUser;
        this.nombreUser = nombreUser;
        this.passUser = passUser;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }
    
    
          
}
