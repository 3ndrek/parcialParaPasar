package com.recuperatorio.parcialRecuperatorio.repositories;

import com.recuperatorio.parcialRecuperatorio.models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaylistRepository extends JpaRepository<Playlist,Integer> {
}
