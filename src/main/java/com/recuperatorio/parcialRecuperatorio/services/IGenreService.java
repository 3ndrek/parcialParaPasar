package com.recuperatorio.parcialRecuperatorio.services;


import com.recuperatorio.parcialRecuperatorio.models.DTOS.GenreDTO;
import com.recuperatorio.parcialRecuperatorio.models.Genre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IGenreService {
    Genre create(GenreDTO genre);

    Genre update(GenreDTO genre);


    Genre delete(int id);

    List<Genre> getAll();

    Genre findById(int id);
}
