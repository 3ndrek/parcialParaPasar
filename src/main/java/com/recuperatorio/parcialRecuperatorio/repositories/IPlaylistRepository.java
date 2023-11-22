package com.recuperatorio.parcialRecuperatorio.repositories;

import com.recuperatorio.parcialRecuperatorio.models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaylistRepository extends JpaRepository<Playlist,Integer> {
    @Query(value = "DELETE FROM playlist_track WHERE playlist = ?1", nativeQuery = true)
    public void deletePlaylistTrackByPlaylistId(int id);
}
