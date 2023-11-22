package com.recuperatorio.parcialRecuperatorio.controllers;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.TrackDTO;
import com.recuperatorio.parcialRecuperatorio.models.Track;
import com.recuperatorio.parcialRecuperatorio.services.ITrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/track")
@RequiredArgsConstructor
public class TrackController {
    @Autowired
    private ITrackService trackService;

    @GetMapping()
    public ResponseEntity<Object> getAll(){
        List<Track> tracks;
        try{
            tracks = trackService.getAll();
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema al encontrar las playlist" + ex.getMessage());
        }
        return ResponseEntity.ok(tracks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id){
        Track track;
        try{
            track = trackService.findById(id);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema: " + ex.getMessage());
        }
        return ResponseEntity.ok(track);
    }

    @PostMapping()
    public ResponseEntity<Object> createPlaylist(@RequestBody TrackDTO track){
        Track track1;
        try{
            track1 = trackService.create(track);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema: " + ex.getMessage());
        }
        return ResponseEntity.ok(track1);
    }

    @PutMapping()
    public ResponseEntity<Object> updatePlaylist( @RequestBody TrackDTO track){
        Track track1;
        try{
            track1 = trackService.update( track);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema: " + ex.getMessage());
        }
        return ResponseEntity.ok(track1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePlaylist(@PathVariable int id){
        Track track;
        try{
            track = trackService.delete(id);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Hubo un problema: " + ex.getMessage());
        }
        return ResponseEntity.ok("Se eliminó el Invoice Item con id: " + id);
    }
}
