package com.recuperatorio.parcialRecuperatorio.models.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AlbumDTO {
    private int albumid;
    private String title;
    private int artist;
}
