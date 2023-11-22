package com.recuperatorio.parcialRecuperatorio.models.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackFiltradoDTO {

    /// TrackId, TrackName, AlbumName, Segundos y UnitPrice

    private int trackId;

    private String trackName;

    private String albumName;

    private int segundos;

    private double unitPrice;

}
