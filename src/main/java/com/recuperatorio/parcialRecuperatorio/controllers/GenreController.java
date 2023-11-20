package com.recuperatorio.parcialRecuperatorio.controllers;

import com.recuperatorio.parcialRecuperatorio.models.Genre;
import com.recuperatorio.parcialRecuperatorio.services.GenreServiceImpl;
import com.recuperatorio.parcialRecuperatorio.services.IGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
