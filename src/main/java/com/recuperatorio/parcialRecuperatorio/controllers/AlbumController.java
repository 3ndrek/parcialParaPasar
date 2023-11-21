package com.recuperatorio.parcialRecuperatorio.controllers;

import com.recuperatorio.parcialRecuperatorio.models.Album;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.AlbumDTO;
import com.recuperatorio.parcialRecuperatorio.services.IAlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/album")
@RequiredArgsConstructor
public class AlbumController {
    private IAlbumService albumService;
    public AlbumController(IAlbumService albumService) {
        this.albumService = albumService;
    }
    @GetMapping
    public ResponseEntity<Object>  getAll(){
        List<Album> albums;
        try{
            albums = albumService.getAll();
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al encontrar los albums" + ex.getMessage());
        }
        return ResponseEntity.ok(albums);
    }

    @PostMapping
    public ResponseEntity<Object>  create(@RequestBody AlbumDTO album){
        try {
            return ResponseEntity.ok(albumService.create(album));
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al crear el album" + ex.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object>  update(@RequestBody AlbumDTO album){
        try {
            return ResponseEntity.ok(albumService.update(album));
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al actualizar el album" + ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object>  delete(@PathVariable int id){
        Album album;
        try {
            album = albumService.delete(id);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al eliminar el album" + ex.getMessage());
        }
        return ResponseEntity.ok("Se eliminó el album con id: " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>  getById(@PathVariable int id){
        Album album;
        try {
            album = albumService.findById(id);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al encontrar el album" + ex.getMessage());
        }
        return ResponseEntity.ok(album);
    }
}

