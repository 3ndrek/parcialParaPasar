package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.PlaylistDTO;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.PlaylistTrackDTO;
import com.recuperatorio.parcialRecuperatorio.models.Playlist;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IPlaylistService {
    Playlist create(PlaylistDTO playlist);
    Playlist update(PlaylistDTO playlist);
    Playlist delete(int id);
    List<Playlist> getAll();
    Playlist findById(int id);
    Playlist addTrack(PlaylistTrackDTO playlistTrackDTO);
    Playlist deleteTrack(PlaylistTrackDTO playlistTrackDTO);
}
