package com.recuperatorio.parcialRecuperatorio.models;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.PlaylistDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "playlists")
@Entity
public class Playlist  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="playlistid")
    private int playlistId;
    @Column(name="name")
    private String name;


    @ManyToMany
    @JoinTable(
            name = "playlist_track",
            joinColumns = {@JoinColumn(name = "playlistid")},
            inverseJoinColumns = {@JoinColumn(name = "trackid")}
    )
    private List<Track> tracks;
    public void update(PlaylistDTO dto){
        this.name = dto.getName();
    }
    public Playlist(PlaylistDTO dto){
        this.name = dto.getName();
    }
    public void addTrack(Track track){
        this.tracks.add(track);
    }

}
