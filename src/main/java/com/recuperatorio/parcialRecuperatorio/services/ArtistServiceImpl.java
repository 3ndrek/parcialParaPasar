package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.Artist;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.ArtistDTO;
import com.recuperatorio.parcialRecuperatorio.models.Playlist;
import com.recuperatorio.parcialRecuperatorio.repositories.IArtistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements IArtistService {
    private IArtistRepository artistRepository;
    public  ArtistServiceImpl(IArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }
    @Override
    public Artist create(ArtistDTO artist) {
        if (artist.getName().length() > 120){
            throw new IllegalArgumentException("El nombre del artista no puede superar los 120 caracteres");
        }
        Artist nuevoArtist = new Artist();
        nuevoArtist.update(artist);
        return this.artistRepository.save(nuevoArtist);
    }

    @Override
    public Artist update(ArtistDTO artist) {
        if (artist.getName().length() > 120) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitud del nombre es mayor a 120 caracteres");
        }
        // buscamos la playlist original (si no existe, lanza excepcion)
        Artist artistaOriginal = this.findById(artist.getId());

        artistaOriginal.update(artist);

        this.artistRepository.save(artistaOriginal);

        return artistaOriginal;
    }

    @Override
    public Artist delete(int id) {
        Artist artist = this.findById(id);
        // si no es null lo borramos
        artistRepository.delete(artist);
        return artist;
    }

    @Override
    public List<Artist> getAll() {
        List<Artist> artists = this.artistRepository.findAll();
        return artists;
    }

    @Override
    public Artist findById(int id) {
        return this.artistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Playlist no encontrada") );

    }
}
