package com.recuperatorio.parcialRecuperatorio.controllers;


import com.recuperatorio.parcialRecuperatorio.models.Artist;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.ArtistDTO;
import com.recuperatorio.parcialRecuperatorio.services.IArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artist")
@RequiredArgsConstructor
public class ArtistController {
    private IArtistService artistService;
    public ArtistController(IArtistService artistService ) {
        this.artistService = artistService;
    }
    @GetMapping()
    public ResponseEntity<Object> getAll(){
        List<Artist> artists;
        try{
            artists = artistService.getAll();
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al encontrar las playlist" + ex.getMessage());
        }
        return ResponseEntity.ok(artists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id){
        Artist artist;
        try{
            artist = artistService.findById(id);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema: " + ex.getMessage());
        }
        return ResponseEntity.ok(artist);
    }

    @PostMapping()
    public ResponseEntity<Object> createPlaylist(@RequestBody ArtistDTO artistDTO){
        Artist artist;
        try{
            artist = artistService.create(artistDTO);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema: " + ex.getMessage());
        }
        return ResponseEntity.ok(artist);
    }

    @PutMapping()
    public ResponseEntity<Object> updatePlaylist( @RequestBody ArtistDTO artistDTO){
       Artist artist;
        try{
            artist = artistService.update( artistDTO);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema: " + ex.getMessage());
        }
        return ResponseEntity.ok(artist);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePlaylist(@PathVariable int id){
        Artist artist;
        try{
            artist = artistService.delete(id);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema: " + ex.getMessage());
        }
        // retorno el mensaje de que el borrado fue exitoso con el id de la playlist
        return ResponseEntity.ok("Se borro la playlist con id: " + artist.getArtistId());
    }

}
