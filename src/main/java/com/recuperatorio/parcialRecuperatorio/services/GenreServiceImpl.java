package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.GenreDTO;
import com.recuperatorio.parcialRecuperatorio.models.Genre;
import com.recuperatorio.parcialRecuperatorio.repositories.IGenreRepository;
import com.recuperatorio.parcialRecuperatorio.services.mappers.GenreDTOToGenre;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements IGenreService{

    private IGenreRepository genreRepository;
    private GenreDTOToGenre mapperDto;

    public GenreServiceImpl(IGenreRepository genreRepository, GenreDTOToGenre mapperDto){
        this.mapperDto = mapperDto;
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre create(GenreDTO genre) {
        if(genre.getName().length()>120){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitud del nombre es mayor al máximo permitido");
        }

        Genre genreAGuardar = mapperDto.convertDtoToGenre(genre);
        Genre nueva = genreRepository.save(genreAGuardar);
        if (nueva == null)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo registrar");
        }

        return nueva;
    }

    @Override
    public Genre update(GenreDTO genre){
        if(genre.getName().length()>120){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitud del nombre es mayor al máximo permitido");
        }
        Genre genreAActualizar = genreRepository.findById(genre.getId()).orElseThrow(() -> new IllegalArgumentException("Genre no encontrado"));
        genreAActualizar.update(genre.getName());
        return genreRepository.save(genreAActualizar);
    }

    @Override
    public Genre delete(int id){
        Genre genreBorrado = genreRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Genre no encontrado"));
        genreRepository.deleteById(id);
        return genreBorrado;
    }

    @Override
    public List<Genre> getAll(){
        return genreRepository.findAll();
    }

    @Override
    public Genre findById(int id){
        return genreRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Genre no encontrado"));
    }
}
