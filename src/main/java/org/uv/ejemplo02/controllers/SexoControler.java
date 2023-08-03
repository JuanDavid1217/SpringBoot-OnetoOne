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
import org.uv.ejemplo02.models.Sexo;
import org.uv.ejemplo02.repository.SexoRepository;

/**
 *
 * @author juan
 */
@RestController
@RequestMapping("/API/Sexo")
public class SexoControler {
    @Autowired
    SexoRepository sr;
    
    @GetMapping
    public ResponseEntity<Page<Sexo>> listaSexos(Pageable pageable){
        return ResponseEntity.ok(sr.findAll(pageable));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Sexo> sexobyID(@PathVariable long id){
        Optional<Sexo> s= sr.findById(id);
        
        if(!s.isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(s.get());
    }
    
    @PostMapping
    public ResponseEntity<Sexo> savesexo(@RequestBody Sexo s){
        Sexo sg=sr.save(s);
        
        URI ubication = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(sg.getId()).toUri();
        
        return ResponseEntity.created(ubication).body(sg);
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Sexo> updatesexo(@PathVariable long id, @RequestBody Sexo s){
        Optional <Sexo> os=sr.findById(id);
        
        if(!os.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        
        s.setId(os.get().getId());
        
        sr.save(s);
        
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Sexo> deletesexo(@PathVariable long id){
        Optional<Sexo> os=sr.findById(id);
        
        if(!os.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        
        sr.delete(os.get());
        
        return ResponseEntity.noContent().build();
    }
}
