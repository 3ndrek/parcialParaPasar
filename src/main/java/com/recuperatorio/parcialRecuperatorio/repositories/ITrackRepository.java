package com.recuperatorio.parcialRecuperatorio.repositories;

import com.recuperatorio.parcialRecuperatorio.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrackRepository extends JpaRepository<Track,Integer> {
    // borrar todos las filas de playlist_tack con un id track
    @Modifying
    @Query(value = "DELETE FROM playlist_track WHERE trackid =:id", nativeQuery = true)
    void deletePlaylistTrack(@Param("id") String id);
}
