package com.recuperatorio.parcialRecuperatorio.repositories;

import com.recuperatorio.parcialRecuperatorio.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArtistRepository extends JpaRepository<Artist,Integer> {
}
