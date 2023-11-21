package com.recuperatorio.parcialRecuperatorio.controllers;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.GenreDTO;
import com.recuperatorio.parcialRecuperatorio.models.Genre;
import com.recuperatorio.parcialRecuperatorio.services.GenreServiceImpl;
import com.recuperatorio.parcialRecuperatorio.services.IGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
@RequiredArgsConstructor
public class GenreController {
    @Autowired
    private IGenreService genreService;

    @GetMapping()
    public ResponseEntity<Object> getAll(){
        List<Genre> genres;
        try{
            genres = genreService.getAll();
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al encontrar los géneros" + ex.getMessage());
        }
        return ResponseEntity.ok(genres);

    }
    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody GenreDTO genreDTO){
        Genre genre;
        try{
            genre = genreService.create(genreDTO);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al crear el género" + ex.getMessage());
        }
        return ResponseEntity.ok(genre);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id){
        Genre genre;
        try{
            genre = genreService.findById(id);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al encontrar el género" + ex.getMessage());
        }
        return ResponseEntity.ok(genre);
    }
    @PutMapping()
    public ResponseEntity<Object> update(@RequestBody GenreDTO genreDTO){
        Genre genre;
        try{
            genre = genreService.update(genreDTO);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al actualizar el género" + ex.getMessage());
        }
        return ResponseEntity.ok(genre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable  int id){
        try{
            genreService.delete(id);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al eliminar el género" + ex.getMessage());
        }
        return ResponseEntity.ok("Se eliminó el género con id: " + id);
    }
}
