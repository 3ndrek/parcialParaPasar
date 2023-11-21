package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.PlaylistDTO;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.PlaylistTrackDTO;
import com.recuperatorio.parcialRecuperatorio.models.Playlist;
import com.recuperatorio.parcialRecuperatorio.models.Track;
import com.recuperatorio.parcialRecuperatorio.repositories.IPlaylistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class PlaylistServiceImpl implements IPlaylistService{

    private IPlaylistRepository playlistRepository;
    private ITrackService trackService;
    public PlaylistServiceImpl(IPlaylistRepository playlistRepository, ITrackService trackService) {
        this.playlistRepository = playlistRepository;
        this.trackService = trackService;
    }

    @Override
    public Playlist create(PlaylistDTO playlist) {
        if(playlist.getName().length()>120){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitud del nombre es mayor a 120 caracteres");
        }
        Playlist nuevaPlaylist = new Playlist(playlist);
        playlistRepository.save(nuevaPlaylist);
        return nuevaPlaylist;
    }

    @Override
    public Playlist update(PlaylistDTO playlist) {
        if (playlist.getName().length() > 120) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitud del nombre es mayor a 120 caracteres");
        }
        // buscamos la playlist original (si no existe, lanza excepcion)
        Playlist playlistOriginal = this.findById(playlist.getId());

        playlistOriginal.update(playlist);

        this.playlistRepository.save(playlistOriginal);

        return playlistOriginal;
    }



    @Override
    public Playlist delete(int id) {
        Playlist playlist = this.findById(id);
        this.playlistRepository.delete( playlist);

        return playlist;
    }

    @Override
    public List<Playlist> getAll() {
        List<Playlist> playlists = playlistRepository.findAll();
        return playlists;
    }

    @Override
    public Playlist findById(int id) {
        Playlist playlist = playlistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Playlist no encontrada"));
        return playlist;

    }
    @Override
    public Playlist addTrack(PlaylistTrackDTO playlistTrackDTO) {
        Playlist playlist = this.findById(playlistTrackDTO.getIdPlaylist());
        Track track = this.trackService.findById(playlistTrackDTO.getIdTrack());
        // agregamos el track a la playlist
        playlist.addTrack(track);
        // guardamos la playlist esto guardara el track nuevo en la playlist
        this.playlistRepository.save(playlist);
        return playlist;
    }
}
