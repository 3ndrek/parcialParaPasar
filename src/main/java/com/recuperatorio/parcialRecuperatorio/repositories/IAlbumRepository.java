package com.recuperatorio.parcialRecuperatorio.repositories;

import com.recuperatorio.parcialRecuperatorio.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IAlbumRepository extends JpaRepository<Album,Integer> {
}
