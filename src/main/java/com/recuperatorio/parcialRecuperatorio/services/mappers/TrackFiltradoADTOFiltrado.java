package com.recuperatorio.parcialRecuperatorio.services.mappers;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.TrackFiltradoDTO;
import com.recuperatorio.parcialRecuperatorio.models.Track;
import org.springframework.stereotype.Service;

@Service
public class TrackFiltradoADTOFiltrado {
    public TrackFiltradoDTO transcribir(Track t) {
        TrackFiltradoDTO trackFiltradoDTO = new TrackFiltradoDTO(t.getTrackId(), t.getName(), t.getAlbum().getTitle(),t.getMiliseconds(),t.getUnitPrice());
        return trackFiltradoDTO;
    }
}