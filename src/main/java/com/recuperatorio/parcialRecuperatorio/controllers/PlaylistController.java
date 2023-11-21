package com.recuperatorio.parcialRecuperatorio.controllers;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.PlaylistDTO;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.PlaylistTrackDTO;
import com.recuperatorio.parcialRecuperatorio.models.Playlist;
import com.recuperatorio.parcialRecuperatorio.services.IPlaylistService;
import com.recuperatorio.parcialRecuperatorio.services.PlaylistServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlist")
@RequiredArgsConstructor
public class PlaylistController {

    @Autowired
    private IPlaylistService playlistService;

    @GetMapping()
    public ResponseEntity<Object> getAll(){
        List<Playlist> playlists;
        try{
             playlists = playlistService.getAll();
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al encontrar las playlist" + ex.getMessage());
        }
        return ResponseEntity.ok(playlists);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id){
        Playlist playlist;
        try{
            playlist = playlistService.findById(id);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema: " + ex.getMessage());
        }
        return ResponseEntity.ok(playlist);
    }


    @PostMapping()
    public ResponseEntity<Object> createPlaylist(@RequestBody PlaylistDTO playlistDTO){
        Playlist playlist;
        try{
            playlist = playlistService.create(playlistDTO);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema: " + ex.getMessage());
        }
        return ResponseEntity.ok(playlist);
    }


    @PutMapping()
    public ResponseEntity<Object> updatePlaylist( @RequestBody PlaylistDTO playlistDTO){
        Playlist playlist;
        try{
            playlist = playlistService.update( playlistDTO);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema: " + ex.getMessage());
        }
        return ResponseEntity.ok(playlist);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePlaylist(@PathVariable int id){
        Playlist playlist;
        try{
            playlist = playlistService.delete(id);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema: " + ex.getMessage());
        }
        // retorno el mensaje de que el borrado fue exitoso con el id de la playlist
        return ResponseEntity.ok("Se borro la playlist con id: " + playlist.getPlaylistId());
    }
    @PostMapping("/addTrack")
    public ResponseEntity<Object> addTrack(@RequestBody PlaylistTrackDTO playlistTrackDTO){
        Playlist playlist;
        try{
            playlist = playlistService.addTrack(playlistTrackDTO);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema: " + ex.getMessage());
        }
        return ResponseEntity.ok(playlist);
    }

}
