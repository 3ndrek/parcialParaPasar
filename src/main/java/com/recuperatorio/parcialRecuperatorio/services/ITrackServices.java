package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.TrackDTO;
import com.recuperatorio.parcialRecuperatorio.models.Track;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ITrackServices {
    Track create(TrackDTO track);

    Track update(TrackDTO track);


    Track delete(int id);

    List<Track> getAll();

    Track findById(int id);


}
