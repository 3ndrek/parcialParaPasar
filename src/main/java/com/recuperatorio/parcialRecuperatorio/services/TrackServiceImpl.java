package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.TrackDTO;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.TrackFiltradoDTO;
import com.recuperatorio.parcialRecuperatorio.models.Track;
import com.recuperatorio.parcialRecuperatorio.repositories.IPlaylistTrackRepository;
import com.recuperatorio.parcialRecuperatorio.repositories.ITrackRepository;
import com.recuperatorio.parcialRecuperatorio.services.mappers.TrackDTOToTrack;
import com.recuperatorio.parcialRecuperatorio.services.mappers.TrackFiltradoADTOFiltrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.recuperatorio.parcialRecuperatorio.models.Album;
import com.recuperatorio.parcialRecuperatorio.models.Genre;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TrackServiceImpl implements ITrackService {

    private ITrackRepository repositoryTrack;

    private TrackDTOToTrack mapperdto;
    private IPlaylistTrackRepository playlistTrackRepository;
    private IGenreService generoService;
    private IAlbumService albumService;

    private IArtistService servicioArtistas;
@Autowired
    private TrackFiltradoADTOFiltrado dtoFiltradoMapper;

    public TrackServiceImpl(ITrackRepository repositoryTrack, TrackDTOToTrack mapperdto, IPlaylistTrackRepository playlistTrackRepository, IGenreService generoService, IAlbumService albumService, IArtistService servicioArtistas) {
        this.repositoryTrack = repositoryTrack;
        this.mapperdto = mapperdto;
        this.playlistTrackRepository = playlistTrackRepository;
        this.generoService = generoService;
        this.albumService = albumService;
        this.servicioArtistas = servicioArtistas;
    }

    @Override
    public Track create(TrackDTO track) {

        Track acrear = mapperdto.convertDtoToTrack(track);

        Album album = albumService.findById(track.getAlbum());
        Genre genero = generoService.findById(track.getGenreId());


        acrear.setAlbum(album);
        acrear.setGenre(genero);


        Track nueva = repositoryTrack.save(acrear);

        if (nueva == null)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "no se pudo registrar");
        }

        return nueva;
    }

    @Override
    public Track update(TrackDTO track) {

        Track trackOriginal = findById(track.getId());
        // compruebo si existe el album
        Album album = albumService.findById(track.getAlbum());
        // compruebo si existe el genero
        Genre genero = generoService.findById(track.getGenreId());
        trackOriginal.update(track, album, genero);
        repositoryTrack.save(trackOriginal);

        return trackOriginal;
    }

    @Override
    public Track delete(int id) {
        Track track = this.findById(id);

        this.repositoryTrack.delete(track);

        this.playlistTrackRepository.deleteByTrackId(id);
        return track;

    }

    @Override
    public List<Track> getAll() {
        List<Track> tracks = repositoryTrack.findAll();
        return tracks;
    }

    @Override
    public Track findById(int id) {
        Track track = repositoryTrack.findById(id).orElseThrow(() -> new IllegalArgumentException("Track no encontrado"));
        return track;

    }

    @Override
    public List<TrackFiltradoDTO> getFiltrados(int id) {


        if (!this.servicioArtistas.existeArtista(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no existe el artista");
        } else {
            List<Track> tracks = this.repositoryTrack.findByAlbum_Artist_ArtistId(id);

            if (tracks.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NO_CONTENT, "no existen canciones de ese genero para ese artista");
            } else {
                List<TrackFiltradoDTO> trackFiltradoDTOS = new ArrayList();
                Iterator var5 = tracks.iterator();

                while (var5.hasNext()) {
                    Track track = (Track) var5.next();
                    TrackFiltradoDTO t = this.dtoFiltradoMapper.transcribir(track);
                    trackFiltradoDTOS.add(t);
                }

                return trackFiltradoDTOS;
            }
        }
    }
}
