package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.Album;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.AlbumDTO;
import com.recuperatorio.parcialRecuperatorio.models.Playlist;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface IAlbumService {

    Album create(AlbumDTO album );
    Album update(AlbumDTO album);
    Album delete(AlbumDTO album);
    Album delete(int id);
    List<Album> getAll();
    Album findById(int id);

}
