package com.recuperatorio.parcialRecuperatorio.services.mappers;

import com.recuperatorio.parcialRecuperatorio.models.Album;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.AlbumDTO;
import com.recuperatorio.parcialRecuperatorio.models.Genre;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class AlbumDTOToAlbum {
    public Album convertDtoToAlbum (AlbumDTO dto)
    {
        Album album = new Album(dto.getArtist(),dto.getTitle(), null);
        return album;
    }
}
