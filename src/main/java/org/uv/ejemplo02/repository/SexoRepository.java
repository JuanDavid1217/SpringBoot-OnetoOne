/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.ejemplo02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uv.ejemplo02.models.Sexo;

/**
 *
 * @author juan
 */
public interface SexoRepository extends JpaRepository<Sexo, Long>{
    
}
