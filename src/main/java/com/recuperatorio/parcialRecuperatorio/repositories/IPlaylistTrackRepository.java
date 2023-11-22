package com.recuperatorio.parcialRecuperatorio.repositories;

import com.recuperatorio.parcialRecuperatorio.models.PlaylistTrack;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaylistTrackRepository extends JpaRepository<PlaylistTrack,Integer> {
    @Transactional
    void deleteByTrackId(int id);
}
