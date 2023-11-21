package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.TrackDTO;
import com.recuperatorio.parcialRecuperatorio.models.Track;

import java.util.List;

public interface ITrackService {
    Track create(TrackDTO track);

    Track update(TrackDTO track);


    Track delete(int id);

    List<Track> getAll();

    Track findById(int id);


}
