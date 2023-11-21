package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.Album;
import com.recuperatorio.parcialRecuperatorio.models.Artist;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.AlbumDTO;
import com.recuperatorio.parcialRecuperatorio.repositories.IAlbumRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class AlbumServiceImpl implements IAlbumService {

    private IAlbumRepository albumRepository;
    private IArtistService artistService;
    public AlbumServiceImpl(IAlbumRepository albumRepository, IArtistService artistService) {
        this.albumRepository = albumRepository;
        this.artistService = artistService;
    }

    @Override
    public Album create(AlbumDTO album) {
        if(album.getTitle().length()>160){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitud del nombre es mayor a 160 caracteres");
        }
        Album nuevoAlbum = new Album();
        Artist artista = artistService.findById(album.getArtist());
        nuevoAlbum.update(album, artista);
        albumRepository.save(nuevoAlbum);
        return null;
    }

    @Override
    public Album update(AlbumDTO album) {
        if(album.getTitle().length()>160){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitud del nombre es mayor a 160 caracteres");
        }
        Album albumOriginal = this.findById(album.getAlbumid());
        Artist artista = artistService.findById(album.getArtist());
        albumOriginal.update(album, artista);
        albumRepository.save(albumOriginal);
        return albumOriginal;
    }

    @Override
    public Album delete(AlbumDTO album) {
        Album albumOriginal = this.findById(album.getAlbumid());
        albumRepository.delete(albumOriginal);
        return albumOriginal;
    }

    @Override
    public Album delete(int id) {
        Album album = this.findById(id);
        this.albumRepository.delete( album);
        return album;
    }

    @Override
    public List<Album> getAll() {
        List<Album> albums = albumRepository.findAll();
        return albums;
    }

    @Override
    public Album findById(int id) {
        return this.albumRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Album no encontrado"));
    }
}
