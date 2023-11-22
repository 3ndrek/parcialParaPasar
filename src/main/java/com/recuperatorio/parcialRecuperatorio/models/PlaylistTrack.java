package com.recuperatorio.parcialRecuperatorio.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "playlist_track")
public class PlaylistTrack {
    @Id
    @Column(name = "playlisttrackid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playlistTrackId;
    @Column(name = "playlistid")
    private int playlistId;
    @Column(name = "trackid")
    private int trackId;

}
