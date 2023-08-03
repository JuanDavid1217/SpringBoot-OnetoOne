/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.ejemplo02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uv.ejemplo02.models.Estudiante;

/**
 *
 * @author juan
 */
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    
}
