package com.recuperatorio.parcialRecuperatorio.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Data
@Entity
@Table(name = "tracks")
@NoArgsConstructor
@AllArgsConstructor
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trackid")
    private int trackId;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "albumid")
    private Album albumId;

    @Column(name = "mediatypeid")
    private Integer mediaTypeId;

    @ManyToOne
    @JoinColumn(name = "genreid")
    private Genre genreId;

    @Column(name="composer")
    private String composer;

    @Column(name="milliseconds")
    private int miliseconds;

    @Column(name="bytes")
    private int bytes;

    @Column(name="unitprice")
    private double unitPrice;

    public Track(String name, Album albumId, Integer mediatype, Genre genreId, String composer, int miliseconds, int bytes, double unitPrice) {
        this.name = name;
        this.albumId = albumId;
        this.mediaTypeId = mediaTypeId;
        this.genreId = genreId;
        this.composer = composer;
        this.miliseconds = miliseconds;
        this.bytes = bytes;
        this.unitPrice = unitPrice;
    }



    public void update(String name, Album album, int mediaType, Genre genre, String composer, int milliseconds, Integer bytes, float unitPrice) {
        this.name = name;
        this.albumId = album;
        this.mediaTypeId = mediaType;
        this.genreId = genre;
        this.composer = composer;
        this.miliseconds = milliseconds;
        this.bytes = bytes;
        this.unitPrice = unitPrice;
    }

}
