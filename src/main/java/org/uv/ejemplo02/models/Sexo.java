/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.ejemplo02.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "sexos")
public class Sexo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_sexo")
    private long id;
    
    @Column(name ="tipo")
    private char tipo;
    
    /* Constructors */
    public Sexo(){}
    
    public Sexo(char tipo){
        this.tipo=tipo;
    }
    
    public Sexo(long id, char tipo){
        this.id=id;
        this.tipo=tipo;
    }
    
    /* Setters and Getters */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
}
