package com.recuperatorio.parcialRecuperatorio.models;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.TrackDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    private Album album;

    @Column(name = "mediatypeid")
    private Integer mediaTypeId;

    @ManyToOne
    @JoinColumn(name = "genreid")
    private Genre genre;

    @Column(name="composer")
    private String composer;

    @Column(name="milliseconds")
    private int miliseconds;

    @Column(name="bytes")
    private int bytes;

    @Column(name="unitprice")
    private double unitPrice;


    public Track(String name, Album album, Integer mediatype, Genre genre, String composer, int miliseconds, int bytes, double unitPrice) {
        this.name = name;
        this.album = album;
        this.mediaTypeId = mediaTypeId;
        this.genre = genre;
        this.composer = composer;
        this.miliseconds = miliseconds;
        this.bytes = bytes;
        this.unitPrice = unitPrice;
    }



    public void update(TrackDTO trackdto, Album album, Genre genre) {
        this.name = trackdto.getName();
        this.album = album;
        this.mediaTypeId = trackdto.getMediaType();
        this.genre = genre;
        this.composer = trackdto.getComposer();
        this.miliseconds = trackdto.getMili();
        this.bytes = trackdto.getBytes();
        this.unitPrice = trackdto.getUnitPrice();

    }

}
