
package com.Porfolio.AP.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyectos {
    
    @Id
    @GeneratedValue (strategy =GenerationType.AUTO)
    
    public  Long id;
    
    public String nombre;
    public String descripcion;
    public String link;

    public Proyectos() {
    }

    public Proyectos(Long id, String nombre, String descripcion, String link) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.link = link;
    }
    
}
