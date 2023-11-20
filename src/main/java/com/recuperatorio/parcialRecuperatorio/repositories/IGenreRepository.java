package com.recuperatorio.parcialRecuperatorio.repositories;

import com.recuperatorio.parcialRecuperatorio.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenreRepository extends JpaRepository<Genre,Integer> {
}
