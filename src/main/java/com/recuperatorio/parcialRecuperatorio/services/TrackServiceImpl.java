package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.TrackDTO;
import com.recuperatorio.parcialRecuperatorio.models.Track;
import com.recuperatorio.parcialRecuperatorio.repositories.IAlbumRepository;
import com.recuperatorio.parcialRecuperatorio.repositories.ITrackRepository;
import com.recuperatorio.parcialRecuperatorio.services.mappers.TrackDTOToTrack;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.recuperatorio.parcialRecuperatorio.models.Album;
import com.recuperatorio.parcialRecuperatorio.models.Genre;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;
@Service
public class TrackServiceImpl implements ITrackServices{

    private ITrackRepository repositoryTrack;

    private TrackDTOToTrack mapperdto;

    private IGenreService generoService;
    private IAlbumRepository albumRepository;



    @Override
    public Track create(TrackDTO track) {

        Track acrear = mapperdto.convertDtoToTrack(track);

        Optional<Album> albumB = albumRepository.findById(track.getAlbum());
        Album album = albumB.get();
        Optional<Genre> genero = generoService.findById(track.getGenreId());


        acrear.setAlbumId(album);
        acrear.setGenreId(genero.get());


        Track nueva = repositoryTrack.save(acrear);

        if (nueva == null)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "no se pudo registrar");
        }

        return nueva;
    }

    @Override
    public Track update(TrackDTO track) {
//        Playlist playlistOriginal = this.findById(playlist.getId());
//        playlistOriginal.update(playlist);
//        this.playlistRepository.save(playlistOriginal);
        Track trackOriginal = findById(track.getId());
        Optional<Album> albumB = albumRepository.findById(track.getAlbum());
        Album album = albumB.get();

        Optional<Genre> genero = generoService.findById(track.getGenreId());


        return null;
    }
    //(String name, Album album, MediaType mediaType, Genre genre, String composer, int milliseconds, Integer bytes, float unitPrice)

    @Override
    public Track delete(int id) {
        return null;
    }

    @Override
    public List<Track> getAll() {
        return null;
    }

    @Override
    public Track findById(int id) {
        Track track = repositoryTrack.findById(id).orElseThrow(() -> new IllegalArgumentException("Playlist no encontrada"));
        return track;

    }
}
