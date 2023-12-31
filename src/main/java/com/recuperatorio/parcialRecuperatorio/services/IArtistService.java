package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.Artist;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.ArtistDTO;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
public interface IArtistService {
    Artist create(ArtistDTO artist);
    Artist update(ArtistDTO artist);
    Artist delete(int id);
    List<Artist> getAll();
    Artist findById(int id);
    boolean existeArtista(int id);
}
