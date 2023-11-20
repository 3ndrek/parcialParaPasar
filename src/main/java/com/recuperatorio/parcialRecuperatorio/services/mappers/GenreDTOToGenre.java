package com.recuperatorio.parcialRecuperatorio.services.mappers;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.GenreDTO;
import com.recuperatorio.parcialRecuperatorio.models.Genre;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class GenreDTOToGenre {
    public Genre convertDtoToGenre (GenreDTO dto)
    {
        Genre genre = new Genre(dto.getName());
        return genre;
    }
}
