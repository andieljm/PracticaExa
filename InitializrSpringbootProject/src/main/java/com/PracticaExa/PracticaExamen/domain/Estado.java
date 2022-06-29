package com.PracticaExa.PracticaExamen.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

//sirve para tener get a set
@Data
@Entity
@Table (name="estado") //ESTE DEBE IR LIGADO A LA CLASE
public class Estado implements Serializable{
    
    private static final long serialVersionUID = 1L; //SIMPRE DEBE IR ASI POR HABERNET 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEstado; //en java se debe poner con camelCase y en BD CON Guion
    String nombre;
    String continente;
    String capital;
    int poblacion;
    int extensionTerritorio;

    public Estado() {
    }

    public Estado(String nombre, String continente, String capital, int poblacion, int extension_territorio) {
        this.nombre = nombre;
        this.continente = continente;
        this.capital = capital;
        this.poblacion = poblacion;
        this.extensionTerritorio = extension_territorio;
    }
}