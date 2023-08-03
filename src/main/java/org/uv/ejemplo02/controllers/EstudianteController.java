/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.ejemplo02.controllers;

import java.net.URI;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.uv.ejemplo02.models.Estudiante;
import org.uv.ejemplo02.repository.EstudianteRepository;

/**
 *
 * @author juan
 */
@RestController
@RequestMapping("/API/Estudiante")
public class EstudianteController {
    @Autowired
    EstudianteRepository er;
    
    @GetMapping
    public ResponseEntity<Page<Estudiante>> listBibliotecas(Pageable pageable) {
        return ResponseEntity.ok(er.findAll(pageable));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> estudiantebyId(@PathVariable long id){
        
        Optional<Estudiante> estudianteOptional = er.findById(id);

        if (!estudianteOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(estudianteOptional.get());
    }
    
    @PostMapping
    public ResponseEntity<Estudiante> saveestidiante(@RequestBody Estudiante e){
        Estudiante eg=er.save(e);
        
        URI ubication = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(eg.getId()).toUri();
        
        return ResponseEntity.created(ubication).body(eg);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateestudiante(@PathVariable long id, @RequestBody Estudiante e){
        Optional<Estudiante> optionalestudiante = er.findById(id);
        if(!optionalestudiante.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        
        e.setId(optionalestudiante.get().getId());
        
        er.save(e);
        
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Estudiante> deleteestudiante (@PathVariable long id){
        Optional<Estudiante> optionalestudiante = er.findById(id);
        
        if(!optionalestudiante.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        
        er.delete(optionalestudiante.get());
        return ResponseEntity.noContent().build();
    }
    
}
