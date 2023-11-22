package com.recuperatorio.parcialRecuperatorio.models;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.AlbumDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "albums")
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "albumid")
    private int albumId;

    @Column(name = "title")
    private String title;


    @JoinColumn(name = "artistid")
    @ManyToOne
    private Artist artist;

    public void update(AlbumDTO album, Artist artist) {
        this.title = album.getTitle();
        this.artist = artist;
    }


}
