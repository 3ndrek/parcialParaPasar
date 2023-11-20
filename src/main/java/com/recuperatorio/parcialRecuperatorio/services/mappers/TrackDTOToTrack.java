package com.recuperatorio.parcialRecuperatorio.services.mappers;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.TrackDTO;
import com.recuperatorio.parcialRecuperatorio.models.Track;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class TrackDTOToTrack {
    public Track convertDtoToTrack (TrackDTO dto)
    {
        Track track = new Track(dto.getName(),null,null,null, dto.getComposer(),dto.getMili(),dto.getBytes(),
                dto.getUnitPrice());


        return track;
    }
}
