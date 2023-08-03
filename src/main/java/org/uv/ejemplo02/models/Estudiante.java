/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.ejemplo02.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author juan
 */
@Entity
@Table(name="estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "edad")
    private int edad;
    
    @OneToOne(fetch=FetchType.EAGER)
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name="id_sexo")
    private Sexo sexo;
    
    /*Constructor*/
    public Estudiante(){}
    
    public Estudiante(String nombre, int edad, Sexo sexo){
        this.nombre=nombre;
        this.edad=edad;
        this.sexo=sexo;
    }
    
    public Estudiante(long id, String nombre, int edad, Sexo sexo){
        this.id=id;
        this.nombre=nombre;
        this.edad=edad;
        this.sexo=sexo;
    }
    
    /*Setters and Getters */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
}
