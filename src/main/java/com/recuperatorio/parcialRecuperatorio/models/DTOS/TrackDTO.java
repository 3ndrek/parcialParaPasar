package com.recuperatorio.parcialRecuperatorio.models.DTOS;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackDTO {
    private int id;

    private String name;

    private int album;

    private int mediaType;

    private int genreId;

    private String composer;

    private int mili;

    private int bytes;

    private double unitPrice;

}
